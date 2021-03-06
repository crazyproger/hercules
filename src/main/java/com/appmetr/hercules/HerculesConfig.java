package com.appmetr.hercules;

import com.appmetr.hercules.annotations.Entity;
import com.appmetr.hercules.annotations.WideEntity;

import java.util.HashSet;
import java.util.Set;

public class HerculesConfig {
    /* Constants */
    private String clusterName;
    private String keyspaceName;
    private String cassandraHost;
    private int maxActiveConnections;
    private int replicationFactor;
    private Boolean schemaModificationEnabled;

    /* Fields */
    private Set<Class> entityClasses;
    private Set<Class> wideEntityClasses;

    public HerculesConfig() {
    }

    public HerculesConfig(String clusterName, String keyspaceName, String cassandraHost, int maxActiveConnections, int replicationFactor, Boolean schemaModificationEnabled, Set<Class> entityClasses) {
        this.keyspaceName = clusterName;
        this.keyspaceName = keyspaceName;
        this.cassandraHost = cassandraHost;
        this.maxActiveConnections = maxActiveConnections;
        this.replicationFactor = replicationFactor;
        this.schemaModificationEnabled = schemaModificationEnabled;

        this.entityClasses = new HashSet<Class>();
        this.wideEntityClasses = new HashSet<Class>();

        for (Class entityClass : entityClasses) {
            if (entityClass.isAnnotationPresent(Entity.class)) {
                this.entityClasses.add(entityClass);
            } else if (entityClass.isAnnotationPresent(WideEntity.class)) {
                this.wideEntityClasses.add(entityClass);
            } else {
                throw new RuntimeException("Wrong class for entity " + entityClass.getSimpleName());
            }
        }
    }

    public String getClusterName() { return clusterName; }

    public void setClusterName(String clusterName) { this.clusterName = clusterName; }

    public String getKeyspaceName() {
        return keyspaceName;
    }

    public void setKeyspaceName(String keyspaceName) {
        this.keyspaceName = keyspaceName;
    }

    public String getCassandraHost() {
        return cassandraHost;
    }

    public void setCassandraHost(String cassandraHost) {
        this.cassandraHost = cassandraHost;
    }

    public int getMaxActiveConnections() {
        return maxActiveConnections;
    }

    public void setMaxActiveConnections(int maxActiveConnections) {
        this.maxActiveConnections = maxActiveConnections;
    }

    public int getReplicationFactor() {
        return replicationFactor;
    }

    public void setReplicationFactor(int replicationFactor) {
        this.replicationFactor = replicationFactor;
    }

    public Boolean isSchemaModificationEnabled() { return schemaModificationEnabled; }

    public void setSchemaModificationEnabled(Boolean schemaModificationEnabled) {
        this.schemaModificationEnabled = schemaModificationEnabled;
    }

    public Set<Class> getEntityClasses() {
        return entityClasses;
    }

    public void setEntityClasses(Set<Class> entityClasses) {
        this.entityClasses = entityClasses;
    }

    public Set<Class> getWideEntityClasses() {
        return wideEntityClasses;
    }

    public void setWideEntityClasses(Set<Class> wideEntityClasses) {
        this.wideEntityClasses = wideEntityClasses;
    }
}
