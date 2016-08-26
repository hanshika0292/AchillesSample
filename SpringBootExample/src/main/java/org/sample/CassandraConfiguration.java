package org.sample;

/**
 * Created by hanshika on 25/8/16.
 */

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import info.archinnov.achilles.generated.ManagerFactory;
import info.archinnov.achilles.generated.ManagerFactoryBuilder;
import info.archinnov.achilles.embedded.CassandraEmbeddedServerBuilder;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class CassandraConfiguration {

    private static final Logger logger = Logger.getLogger(CassandraConfiguration.class);

    private static final String CLUSTER_NAME = "127.0.0.1";

    @Bean(destroyMethod = "shutDown")
    public ManagerFactory cassandraNativeClusterDev() {
        ManagerFactory managerFactory =  null;
        try {
            final Cluster cluster = CassandraEmbeddedServerBuilder
                    .builder()
                    .cleanDataFilesAtStartup(false)
                    .withDurableWrite(true)
                    .withClusterName(CLUSTER_NAME)
                    .buildNativeCluster();
            final Session session = cluster.connect();
            managerFactory = ManagerFactoryBuilder
                    .builder(cluster)
                    .withDefaultKeyspaceName("spring")
                    .withBeanValidation(true)
                    .withPostLoadBeanValidation(true)
                    .build();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return managerFactory;

    }

}
