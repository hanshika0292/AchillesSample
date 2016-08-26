package org.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.SimpleCommandLinePropertySource;

/**
 * Created by hanshika on 25/8/16.
 */

@SpringBootApplication
public class SampleApplication {

    private static String SPRING_PROFILE_DEVELOPMENT = "dev";

    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(SampleApplication.class);

        SimpleCommandLinePropertySource source = new SimpleCommandLinePropertySource(args);

        // Check if the selected profile has been set as argument.
        // if not the development profile will be added
        addDefaultProfile(app, source);
        app.run(args);

//        ApplicationContext ctx = SpringApplication.run(SampleApplication.class,args);
//        System.out.println("Inspecting the beans provided by Spring Boot:");
//
//        String[] beanNames = ctx.getBeanDefinitionNames();
//        Arrays.sort(beanNames);
//        for(String beanName : beanNames)
//        {
//            System.out.println(beanName);
//        }
//
//        System.out.println(ctx.getDisplayName());
//        System.out.println("This is my first spring boot example");
    }

    private static void addDefaultProfile(SpringApplication app, SimpleCommandLinePropertySource source) {
        if (!source.containsProperty("spring.profiles.active")) {
            app.setAdditionalProfiles(SPRING_PROFILE_DEVELOPMENT);
        }
    }
}
