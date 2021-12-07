package com.keplux.keplex4j.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * <p>A container holding the data necessary for connecting to your local Plex
 * Media Server.
 * Currently, credentials are stored in the {@code application.properties}
 * file with the prefix {@code plex.config}.</p>
 * <br />
 * <h2>Credentials</h2>
 * <table>
 *     <tr>
 *         <th>Name</th>
 *         <th>Example</th>
 *         <th>Description</th>
 *     </tr>
 *     <tr>
 *         <td>{@code host    }</td>
 *         <td>{@code 192.168.0.71}</td>
 *         <td>The address of your server.</td>
 *     </tr>
 *     <tr>
 *         <td>{@code port    }</td>
 *         <td>{@code 32400}, default</td>
 *         <td>The port for your server.</td>
 *     </tr>
 *     <tr>
 *         <td>{@code token   }</td>
 *         <td>{@code {random-string}    }</td>
 *         <td>An authorized token for accessing your server.</td>
 *     </tr>
 * </table>
 * <br />
 * <h2>A Note On Tokens</h2>
 * <p>Temporary tokens can be found while accessing data from your server. For
 * further information, please check the Plex support article
 * <a href="https://support.plex.tv/articles/204059436-finding-an-authentication-token-x-plex-token/">here</a>.</p>
 * <p>Permanent tokens are not yet available for this project. This will be
 * implemented in a future version. However, you can read more on that
 * <a href="https://forums.plex.tv/t/authenticating-with-plex/609370">here</a>
 * .</p>
 *
 * @author Chris Jardine
 * @version 0.1
 */
@Getter
@Setter
@NoArgsConstructor
@Configuration
public class ClientConfiguration {
    protected final Log log = LogFactory.getLog(getClass());

    @Value("${plex.config.host}")
    private String host;

    @Value("${plex.config.port}")
    private String port;

    @Value("${plex.config.token}")
    private String token;

    /**
     * Create custom filter for logging.
     * @return The filter function.
     */
    private ExchangeFilterFunction logRequest() {
        return (clientRequest, next) -> {
            log.info(String.format("%s - %s", clientRequest.method(), clientRequest.url()));
            return next.exchange(clientRequest);
        };
    }

    /**
     * <p>The basis of the {@code WebClient} is created here. It is managed
     * by the
     * Spring IoC container and should only be called in the context of this
     * library.</p>
     * <br />
     * <h2>Basic Requests</h2>
     * <p>The base url is built from the {@code host}, {@code port}, and
     * {@code token} fields. Requests can then use the {@code WebClient} and
     * only have to include the resource URI.</p>
     * <p>Additionally, the {@code
     * "ACCEPT"} header is set to {@code "application/json"} as the
     * Plex API
     * defaults to XML.</p>
     *
     * @return The implementation of the {@code WebClient}.
     */
    @Bean
    public WebClient webClient() {
        // Customize the WebClient to deserialize the root object directly.
        ObjectMapper mapper = new ObjectMapper()
                .findAndRegisterModules()
                .enable(DeserializationFeature.UNWRAP_ROOT_VALUE);
        ExchangeStrategies exchangeStrategies = ExchangeStrategies.builder()
                .codecs(configurer -> configurer.defaultCodecs()
                        .jackson2JsonDecoder(new Jackson2JsonDecoder(mapper)))
                .codecs(configurer -> configurer.defaultCodecs()
                        .maxInMemorySize(100 * 100 * 1024))
                .build();

        // Build the custom WebClient.
        return WebClient.builder()
                .exchangeStrategies(exchangeStrategies)
                .baseUrl(String.format("http://%s:%s", host, port))
                .defaultHeader(HttpHeaders.ACCEPT,
                        MediaType.APPLICATION_JSON_VALUE)
                .filter(logRequest())
                .build();
    }
}
