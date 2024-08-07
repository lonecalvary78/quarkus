package io.quarkus.flyway.runtime;

import java.util.Collections;
import java.util.Map;

import io.quarkus.datasource.common.runtime.DataSourceUtil;
import io.quarkus.runtime.annotations.ConfigDocMapKey;
import io.quarkus.runtime.annotations.ConfigDocSection;
import io.quarkus.runtime.annotations.ConfigItem;
import io.quarkus.runtime.annotations.ConfigPhase;
import io.quarkus.runtime.annotations.ConfigRoot;

@ConfigRoot(name = "flyway", phase = ConfigPhase.RUN_TIME)
public final class FlywayRuntimeConfig {

    /**
     * Gets the {@link FlywayDataSourceRuntimeConfig} for the given datasource name.
     */
    public FlywayDataSourceRuntimeConfig getConfigForDataSourceName(String dataSourceName) {
        if (DataSourceUtil.isDefault(dataSourceName)) {
            return defaultDataSource;
        }
        return namedDataSources.getOrDefault(dataSourceName, FlywayDataSourceRuntimeConfig.defaultConfig());
    }

    /**
     * Flyway configuration for the default datasource.
     */
    @ConfigItem(name = ConfigItem.PARENT)
    public FlywayDataSourceRuntimeConfig defaultDataSource = FlywayDataSourceRuntimeConfig.defaultConfig();

    /**
     * Named datasources.
     */
    @ConfigItem(name = ConfigItem.PARENT)
    @ConfigDocMapKey("datasource-name")
    @ConfigDocSection
    public Map<String, FlywayDataSourceRuntimeConfig> namedDataSources = Collections.emptyMap();
}
