[![status - in development](https://img.shields.io/badge/progress-in_development-fbcd04)](https://)

# keplex4j
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)

keplex4j is a Spring-based API client for [Plex Media Server](https://plex.tv). This library allows you to easily connect to your Plex server and make requests without worrying about all the dirty back-end work.

# Quick Setup
Feel free to follow this guide if you know what you're doing. If you need help, feel free to go through the [guided setup](#Guided-Setup).

## Project Structure
_Note: This will be more straightforward with the first release._

Your project and this library should exist in a base folder as follows:
```
└── Your Project Name
    └── Your Spring Project
        └── src
            └── ...
    └── {cloned keplex4j repo}
```

## Clone the Repository
Clone the repository in the root of your folder containing your project:
```
git clone https://github.com/jardine-chris/keplex4j.git
```

Your project folder should now contain two folders: your Spring project and the keplex4j repository.

## Setting Up Your Spring Project
- **Configure `application.properties`**

Add the following to your `application.properties` file, substituting your server's information:
```
plex.config.host=192.168.0.77
plex.config.host=32400
plex.config.token=kl4h3gDksP_rehdnM2
```

- **Scan for keplex4j**

Annotate your component with the following:
```
@ComponentScan(basePackages = "com.keplux.keplex4j")
```

## Begin Making Requests
To see how to use the library, please see the guide.

# Guided Setup
Before beginning, make sure your project structure is [set up correctly](#Project-Structure) and you have [cloned the repository](#Clone-the-Repository).

## Configure `application.properties`
There are a couple of steps to make before the library is usable. We need to add information to the `application.properties` file that will let us connect to our local Plex server, and we need to make sure the library is being found by our components.

There are three pieces of information needed to allow the keplex4j library to access your Plex server: `host`, `port`, and `token`.

The `host` is the IP address of your Plex server. You'll want to make sure your server has a static IP address--otherwise, your router's DHCP server will eventually assign the IP address to another device and your application will no longer be able to find your server. See your router's documentation for doing this.

The default port for a Plex server is `32400`.

Both the `host` and `port` can be find in your Plex settings under Remote Access > Private.

To find a `token` for your server, see the following article: [Finding an authentication token / X-Plex-Token](https://support.plex.tv/articles/204059436-finding-an-authentication-token-x-plex-token/)

Once you have the required information, open your `application.properties` file in your project's `src/main/resources` directory and add the following, substituting your server's information:
```
plex.config.host=192.168.0.77
plex.config.host=32400
plex.config.token=kl4h3gDksP_rehdnM2
```

## Setting Up a Test Controller
Create a class called `DemoController`. We will use this controller to test some of the library's features.

Annotate the controller with Spring's `@RestController`. If you are new to Spring, consider going through Spring's [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/) tutorial for more in-depth information.

Additionally, we need to scan for the keplex4j package. This is done with the `@ComponentScan` annotation. While we're doing that, let's also tell the controller that we want to route our requests through `"/api"`. The `DemoController` class will look like this:

```
@ComponentScan(basePackages = "com.keplux.keplex4j")
@RestController
@RequestMapping("/api")
public class DemoController {
    /* ... requests go here ... */
}
```

At this point, we can now make requests to our server through `localhost:8080/api`, unless you changed which port Tomcat is using. Swap `8080` for that port.

<div align="center">
    <img src="https://i.imgur.com/QXdyHgz.png" alt="Keplux logo" width="50%" height="auto" /><br />
    <hr />
    <a href="https://www.linkedin.com/in/chris-jardine/">
        <img src="https://cdn2.iconfinder.com/data/icons/social-media-2285/512/1_Linkedin_unofficial_colored_svg-48.png" alt="LinkedIn logo" />
    </a>
    <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
    <a href="https://github.com/jardine-chris">
        <img src="https://cdn4.iconfinder.com/data/icons/social-media-logos-6/512/71-github-48.png" alt="GitHub logo" />
    </a>
    <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
    <a href="https://twitter.com/chrisjavadev">
        <img src="https://cdn2.iconfinder.com/data/icons/social-media-2285/512/1_Twitter3_colored_svg-48.png" alt="Twitter logo" />
    </a>
</div>
