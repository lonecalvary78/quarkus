package io.quarkus.hibernate.orm.deployment;

import java.util.List;

import org.jboss.jandex.DotName;

public final class HibernateOrmTypes {

    private HibernateOrmTypes() {
    }

    public static final List<DotName> PACKAGE_ANNOTATIONS = List.of(
            DotName.createSimple("org.hibernate.annotations.CollectionTypeRegistration"),
            DotName.createSimple("org.hibernate.annotations.CompositeTypeRegistration"),
            DotName.createSimple("org.hibernate.annotations.CompositeTypeRegistrations"),
            DotName.createSimple("org.hibernate.annotations.ConverterRegistration"),
            DotName.createSimple("org.hibernate.annotations.ConverterRegistrations"),
            DotName.createSimple("org.hibernate.annotations.DialectOverride$FilterDefOverrides"),
            DotName.createSimple("org.hibernate.annotations.DialectOverride$FilterDefs"),
            DotName.createSimple("org.hibernate.annotations.DialectOverride$Version"),
            DotName.createSimple("org.hibernate.annotations.EmbeddableInstantiatorRegistration"),
            DotName.createSimple("org.hibernate.annotations.EmbeddableInstantiatorRegistrations"),
            DotName.createSimple("org.hibernate.annotations.FetchProfile"),
            DotName.createSimple("org.hibernate.annotations.FetchProfile$FetchOverride"),
            DotName.createSimple("org.hibernate.annotations.FetchProfiles"),
            DotName.createSimple("org.hibernate.annotations.FilterDef"),
            DotName.createSimple("org.hibernate.annotations.FilterDefs"),
            DotName.createSimple("org.hibernate.annotations.GenericGenerator"),
            DotName.createSimple("org.hibernate.annotations.GenericGenerators"),
            DotName.createSimple("org.hibernate.annotations.JavaTypeRegistration"),
            DotName.createSimple("org.hibernate.annotations.JavaTypeRegistrations"),
            DotName.createSimple("org.hibernate.annotations.JdbcTypeRegistration"),
            DotName.createSimple("org.hibernate.annotations.JdbcTypeRegistrations"),
            DotName.createSimple("org.hibernate.annotations.ListIndexBase"),
            DotName.createSimple("org.hibernate.annotations.NamedNativeQueries"),
            DotName.createSimple("org.hibernate.annotations.NamedNativeQuery"),
            DotName.createSimple("org.hibernate.annotations.NamedQueries"),
            DotName.createSimple("org.hibernate.annotations.NamedQuery"),
            DotName.createSimple("org.hibernate.annotations.SoftDelete"),
            DotName.createSimple("org.hibernate.annotations.TypeRegistration"),
            DotName.createSimple("org.hibernate.annotations.TypeRegistrations"));

    public static final List<DotName> JPA_MAPPING_ANNOTATIONS = List.of(
            DotName.createSimple("jakarta.persistence.Access"),
            DotName.createSimple("jakarta.persistence.AssociationOverride"),
            DotName.createSimple("jakarta.persistence.AssociationOverrides"),
            DotName.createSimple("jakarta.persistence.AttributeOverride"),
            DotName.createSimple("jakarta.persistence.AttributeOverrides"),
            DotName.createSimple("jakarta.persistence.Basic"),
            DotName.createSimple("jakarta.persistence.Cacheable"),
            DotName.createSimple("jakarta.persistence.CollectionTable"),
            DotName.createSimple("jakarta.persistence.Column"),
            DotName.createSimple("jakarta.persistence.ColumnResult"),
            DotName.createSimple("jakarta.persistence.ConstructorResult"),
            DotName.createSimple("jakarta.persistence.Convert"),
            DotName.createSimple("jakarta.persistence.Converter"),
            DotName.createSimple("jakarta.persistence.Converts"),
            DotName.createSimple("jakarta.persistence.DiscriminatorColumn"),
            DotName.createSimple("jakarta.persistence.DiscriminatorValue"),
            DotName.createSimple("jakarta.persistence.ElementCollection"),
            DotName.createSimple("jakarta.persistence.Embeddable"),
            DotName.createSimple("jakarta.persistence.Embedded"),
            DotName.createSimple("jakarta.persistence.EmbeddedId"),
            DotName.createSimple("jakarta.persistence.Entity"),
            DotName.createSimple("jakarta.persistence.EntityListeners"),
            DotName.createSimple("jakarta.persistence.EntityResult"),
            DotName.createSimple("jakarta.persistence.Enumerated"),
            DotName.createSimple("jakarta.persistence.ExcludeDefaultListeners"),
            DotName.createSimple("jakarta.persistence.ExcludeSuperclassListeners"),
            DotName.createSimple("jakarta.persistence.FieldResult"),
            DotName.createSimple("jakarta.persistence.ForeignKey"),
            DotName.createSimple("jakarta.persistence.GeneratedValue"),
            DotName.createSimple("jakarta.persistence.Id"),
            DotName.createSimple("jakarta.persistence.IdClass"),
            DotName.createSimple("jakarta.persistence.Index"),
            DotName.createSimple("jakarta.persistence.Inheritance"),
            DotName.createSimple("jakarta.persistence.JoinColumn"),
            DotName.createSimple("jakarta.persistence.JoinColumns"),
            DotName.createSimple("jakarta.persistence.JoinTable"),
            DotName.createSimple("jakarta.persistence.Lob"),
            DotName.createSimple("jakarta.persistence.ManyToMany"),
            DotName.createSimple("jakarta.persistence.ManyToOne"),
            DotName.createSimple("jakarta.persistence.MapKey"),
            DotName.createSimple("jakarta.persistence.MapKeyClass"),
            DotName.createSimple("jakarta.persistence.MapKeyColumn"),
            DotName.createSimple("jakarta.persistence.MapKeyEnumerated"),
            DotName.createSimple("jakarta.persistence.MapKeyJoinColumn"),
            DotName.createSimple("jakarta.persistence.MapKeyJoinColumns"),
            DotName.createSimple("jakarta.persistence.MapKeyTemporal"),
            DotName.createSimple("jakarta.persistence.MappedSuperclass"),
            DotName.createSimple("jakarta.persistence.MapsId"),
            DotName.createSimple("jakarta.persistence.NamedAttributeNode"),
            DotName.createSimple("jakarta.persistence.NamedEntityGraph"),
            DotName.createSimple("jakarta.persistence.NamedEntityGraphs"),
            DotName.createSimple("jakarta.persistence.NamedNativeQueries"),
            DotName.createSimple("jakarta.persistence.NamedNativeQuery"),
            DotName.createSimple("jakarta.persistence.NamedQueries"),
            DotName.createSimple("jakarta.persistence.NamedQuery"),
            DotName.createSimple("jakarta.persistence.NamedStoredProcedureQueries"),
            DotName.createSimple("jakarta.persistence.NamedStoredProcedureQuery"),
            DotName.createSimple("jakarta.persistence.NamedSubgraph"),
            DotName.createSimple("jakarta.persistence.OneToMany"),
            DotName.createSimple("jakarta.persistence.OneToOne"),
            DotName.createSimple("jakarta.persistence.OrderBy"),
            DotName.createSimple("jakarta.persistence.OrderColumn"),
            DotName.createSimple("jakarta.persistence.PersistenceContext"),
            DotName.createSimple("jakarta.persistence.PersistenceContexts"),
            DotName.createSimple("jakarta.persistence.PersistenceProperty"),
            DotName.createSimple("jakarta.persistence.PersistenceUnit"),
            DotName.createSimple("jakarta.persistence.PersistenceUnits"),
            DotName.createSimple("jakarta.persistence.PostLoad"),
            DotName.createSimple("jakarta.persistence.PostPersist"),
            DotName.createSimple("jakarta.persistence.PostRemove"),
            DotName.createSimple("jakarta.persistence.PostUpdate"),
            DotName.createSimple("jakarta.persistence.PrePersist"),
            DotName.createSimple("jakarta.persistence.PreRemove"),
            DotName.createSimple("jakarta.persistence.PreUpdate"),
            DotName.createSimple("jakarta.persistence.PrimaryKeyJoinColumn"),
            DotName.createSimple("jakarta.persistence.PrimaryKeyJoinColumns"),
            DotName.createSimple("jakarta.persistence.QueryHint"),
            DotName.createSimple("jakarta.persistence.SecondaryTable"),
            DotName.createSimple("jakarta.persistence.SecondaryTables"),
            DotName.createSimple("jakarta.persistence.SequenceGenerator"),
            DotName.createSimple("jakarta.persistence.SequenceGenerators"),
            DotName.createSimple("jakarta.persistence.SqlResultSetMapping"),
            DotName.createSimple("jakarta.persistence.SqlResultSetMappings"),
            DotName.createSimple("jakarta.persistence.StoredProcedureParameter"),
            DotName.createSimple("jakarta.persistence.Table"),
            DotName.createSimple("jakarta.persistence.TableGenerator"),
            DotName.createSimple("jakarta.persistence.TableGenerators"),
            DotName.createSimple("jakarta.persistence.Temporal"),
            DotName.createSimple("jakarta.persistence.Transient"),
            DotName.createSimple("jakarta.persistence.UniqueConstraint"),
            DotName.createSimple("jakarta.persistence.Version"));

    public static final List<DotName> HIBERNATE_MAPPING_ANNOTATIONS = List.of(
            DotName.createSimple("org.hibernate.annotations.Any"),
            DotName.createSimple("org.hibernate.annotations.AnyDiscriminator"),
            DotName.createSimple("org.hibernate.annotations.AnyDiscriminatorValue"),
            DotName.createSimple("org.hibernate.annotations.AnyDiscriminatorValues"),
            DotName.createSimple("org.hibernate.annotations.AnyKeyJavaClass"),
            DotName.createSimple("org.hibernate.annotations.AnyKeyJavaType"),
            DotName.createSimple("org.hibernate.annotations.AnyKeyJdbcType"),
            DotName.createSimple("org.hibernate.annotations.AnyKeyJdbcTypeCode"),
            DotName.createSimple("org.hibernate.annotations.Array"),
            DotName.createSimple("org.hibernate.annotations.AttributeAccessor"),
            DotName.createSimple("org.hibernate.annotations.AttributeBinderType"),
            DotName.createSimple("org.hibernate.annotations.Bag"),
            DotName.createSimple("org.hibernate.annotations.BatchSize"),
            DotName.createSimple("org.hibernate.annotations.Cache"),
            DotName.createSimple("org.hibernate.annotations.Cascade"),
            DotName.createSimple("org.hibernate.annotations.Check"),
            DotName.createSimple("org.hibernate.annotations.Checks"),
            DotName.createSimple("org.hibernate.annotations.Collate"),
            DotName.createSimple("org.hibernate.annotations.CollectionId"),
            DotName.createSimple("org.hibernate.annotations.CollectionIdJavaType"),
            DotName.createSimple("org.hibernate.annotations.CollectionIdJdbcType"),
            DotName.createSimple("org.hibernate.annotations.CollectionIdJdbcTypeCode"),
            DotName.createSimple("org.hibernate.annotations.CollectionIdMutability"),
            DotName.createSimple("org.hibernate.annotations.CollectionIdType"),
            DotName.createSimple("org.hibernate.annotations.CollectionType"),
            DotName.createSimple("org.hibernate.annotations.CollectionTypeRegistration"),
            DotName.createSimple("org.hibernate.annotations.CollectionTypeRegistrations"),
            DotName.createSimple("org.hibernate.annotations.ColumnDefault"),
            DotName.createSimple("org.hibernate.annotations.ColumnTransformer"),
            DotName.createSimple("org.hibernate.annotations.ColumnTransformers"),
            DotName.createSimple("org.hibernate.annotations.Columns"),
            DotName.createSimple("org.hibernate.annotations.Comment"),
            DotName.createSimple("org.hibernate.annotations.Comments"),
            DotName.createSimple("org.hibernate.annotations.CompositeType"),
            DotName.createSimple("org.hibernate.annotations.CompositeTypeRegistration"),
            DotName.createSimple("org.hibernate.annotations.CompositeTypeRegistrations"),
            DotName.createSimple("org.hibernate.annotations.ConverterRegistration"),
            DotName.createSimple("org.hibernate.annotations.ConverterRegistrations"),
            DotName.createSimple("org.hibernate.annotations.CreationTimestamp"),
            DotName.createSimple("org.hibernate.annotations.CurrentTimestamp"),
            DotName.createSimple("org.hibernate.annotations.DialectOverride$Check"),
            DotName.createSimple("org.hibernate.annotations.DialectOverride$Checks"),
            DotName.createSimple("org.hibernate.annotations.DialectOverride$ColumnDefault"),
            DotName.createSimple("org.hibernate.annotations.DialectOverride$ColumnDefaults"),
            DotName.createSimple("org.hibernate.annotations.DialectOverride$DiscriminatorFormula"),
            DotName.createSimple("org.hibernate.annotations.DialectOverride$DiscriminatorFormulas"),
            DotName.createSimple("org.hibernate.annotations.DialectOverride$FilterDefOverrides"),
            DotName.createSimple("org.hibernate.annotations.DialectOverride$FilterDefs"),
            DotName.createSimple("org.hibernate.annotations.DialectOverride$FilterOverrides"),
            DotName.createSimple("org.hibernate.annotations.DialectOverride$Filters"),
            DotName.createSimple("org.hibernate.annotations.DialectOverride$Formula"),
            DotName.createSimple("org.hibernate.annotations.DialectOverride$Formulas"),
            DotName.createSimple("org.hibernate.annotations.DialectOverride$GeneratedColumn"),
            DotName.createSimple("org.hibernate.annotations.DialectOverride$GeneratedColumns"),
            DotName.createSimple("org.hibernate.annotations.DialectOverride$JoinFormula"),
            DotName.createSimple("org.hibernate.annotations.DialectOverride$JoinFormulas"),
            DotName.createSimple("org.hibernate.annotations.DialectOverride$OrderBy"),
            DotName.createSimple("org.hibernate.annotations.DialectOverride$OrderBys"),
            DotName.createSimple("org.hibernate.annotations.DialectOverride$OverridesAnnotation"),
            DotName.createSimple("org.hibernate.annotations.DialectOverride$SQLDelete"),
            DotName.createSimple("org.hibernate.annotations.DialectOverride$SQLDeleteAll"),
            DotName.createSimple("org.hibernate.annotations.DialectOverride$SQLDeleteAlls"),
            DotName.createSimple("org.hibernate.annotations.DialectOverride$SQLDeletes"),
            DotName.createSimple("org.hibernate.annotations.DialectOverride$SQLInsert"),
            DotName.createSimple("org.hibernate.annotations.DialectOverride$SQLInserts"),
            DotName.createSimple("org.hibernate.annotations.DialectOverride$SQLOrder"),
            DotName.createSimple("org.hibernate.annotations.DialectOverride$SQLOrders"),
            DotName.createSimple("org.hibernate.annotations.DialectOverride$SQLRestriction"),
            DotName.createSimple("org.hibernate.annotations.DialectOverride$SQLRestrictions"),
            DotName.createSimple("org.hibernate.annotations.DialectOverride$SQLSelect"),
            DotName.createSimple("org.hibernate.annotations.DialectOverride$SQLSelects"),
            DotName.createSimple("org.hibernate.annotations.DialectOverride$SQLUpdate"),
            DotName.createSimple("org.hibernate.annotations.DialectOverride$SQLUpdates"),
            DotName.createSimple("org.hibernate.annotations.DialectOverride$Version"),
            DotName.createSimple("org.hibernate.annotations.DialectOverride$Where"),
            DotName.createSimple("org.hibernate.annotations.DialectOverride$Wheres"),
            DotName.createSimple("org.hibernate.annotations.DiscriminatorFormula"),
            DotName.createSimple("org.hibernate.annotations.DiscriminatorOptions"),
            DotName.createSimple("org.hibernate.annotations.DynamicInsert"),
            DotName.createSimple("org.hibernate.annotations.DynamicUpdate"),
            DotName.createSimple("org.hibernate.annotations.EmbeddableInstantiator"),
            DotName.createSimple("org.hibernate.annotations.EmbeddableInstantiatorRegistration"),
            DotName.createSimple("org.hibernate.annotations.EmbeddableInstantiatorRegistrations"),
            DotName.createSimple("org.hibernate.annotations.Fetch"),
            DotName.createSimple("org.hibernate.annotations.FetchProfile"),
            DotName.createSimple("org.hibernate.annotations.FetchProfile$FetchOverride"),
            DotName.createSimple("org.hibernate.annotations.FetchProfileOverride"),
            DotName.createSimple("org.hibernate.annotations.FetchProfileOverrides"),
            DotName.createSimple("org.hibernate.annotations.FetchProfiles"),
            DotName.createSimple("org.hibernate.annotations.Filter"),
            DotName.createSimple("org.hibernate.annotations.FilterDef"),
            DotName.createSimple("org.hibernate.annotations.FilterDefs"),
            DotName.createSimple("org.hibernate.annotations.FilterJoinTable"),
            DotName.createSimple("org.hibernate.annotations.FilterJoinTables"),
            DotName.createSimple("org.hibernate.annotations.Filters"),
            DotName.createSimple("org.hibernate.annotations.ForeignKey"),
            DotName.createSimple("org.hibernate.annotations.Formula"),
            DotName.createSimple("org.hibernate.annotations.FractionalSeconds"),
            DotName.createSimple("org.hibernate.annotations.Generated"),
            DotName.createSimple("org.hibernate.annotations.GeneratedColumn"),
            DotName.createSimple("org.hibernate.annotations.GeneratorType"),
            DotName.createSimple("org.hibernate.annotations.GenericGenerator"),
            DotName.createSimple("org.hibernate.annotations.GenericGenerators"),
            DotName.createSimple("org.hibernate.annotations.HQLSelect"),
            DotName.createSimple("org.hibernate.annotations.IdGeneratorType"),
            DotName.createSimple("org.hibernate.annotations.Immutable"),
            DotName.createSimple("org.hibernate.annotations.Imported"),
            DotName.createSimple("org.hibernate.annotations.Index"),
            DotName.createSimple("org.hibernate.annotations.IndexColumn"),
            DotName.createSimple("org.hibernate.annotations.Instantiator"),
            DotName.createSimple("org.hibernate.annotations.JavaType"),
            DotName.createSimple("org.hibernate.annotations.JavaTypeRegistration"),
            DotName.createSimple("org.hibernate.annotations.JavaTypeRegistrations"),
            DotName.createSimple("org.hibernate.annotations.JdbcType"),
            DotName.createSimple("org.hibernate.annotations.JdbcTypeCode"),
            DotName.createSimple("org.hibernate.annotations.JdbcTypeRegistration"),
            DotName.createSimple("org.hibernate.annotations.JdbcTypeRegistrations"),
            DotName.createSimple("org.hibernate.annotations.JoinColumnOrFormula"),
            DotName.createSimple("org.hibernate.annotations.JoinColumnsOrFormulas"),
            DotName.createSimple("org.hibernate.annotations.JoinFormula"),
            DotName.createSimple("org.hibernate.annotations.LazyCollection"),
            DotName.createSimple("org.hibernate.annotations.LazyGroup"),
            DotName.createSimple("org.hibernate.annotations.LazyToOne"),
            DotName.createSimple("org.hibernate.annotations.ListIndexBase"),
            DotName.createSimple("org.hibernate.annotations.ListIndexJavaType"),
            DotName.createSimple("org.hibernate.annotations.ListIndexJdbcType"),
            DotName.createSimple("org.hibernate.annotations.ListIndexJdbcTypeCode"),
            DotName.createSimple("org.hibernate.annotations.Loader"),
            DotName.createSimple("org.hibernate.annotations.ManyToAny"),
            DotName.createSimple("org.hibernate.annotations.MapKeyJavaType"),
            DotName.createSimple("org.hibernate.annotations.MapKeyJdbcType"),
            DotName.createSimple("org.hibernate.annotations.MapKeyJdbcTypeCode"),
            DotName.createSimple("org.hibernate.annotations.MapKeyMutability"),
            DotName.createSimple("org.hibernate.annotations.MapKeyType"),
            DotName.createSimple("org.hibernate.annotations.Mutability"),
            DotName.createSimple("org.hibernate.annotations.NamedNativeQueries"),
            DotName.createSimple("org.hibernate.annotations.NamedNativeQuery"),
            DotName.createSimple("org.hibernate.annotations.NamedQueries"),
            DotName.createSimple("org.hibernate.annotations.NamedQuery"),
            DotName.createSimple("org.hibernate.annotations.Nationalized"),
            DotName.createSimple("org.hibernate.annotations.NaturalId"),
            DotName.createSimple("org.hibernate.annotations.NaturalIdCache"),
            DotName.createSimple("org.hibernate.annotations.NotFound"),
            DotName.createSimple("org.hibernate.annotations.OnDelete"),
            DotName.createSimple("org.hibernate.annotations.OptimisticLock"),
            DotName.createSimple("org.hibernate.annotations.OptimisticLocking"),
            DotName.createSimple("org.hibernate.annotations.OrderBy"),
            DotName.createSimple("org.hibernate.annotations.ParamDef"),
            DotName.createSimple("org.hibernate.annotations.Parameter"),
            DotName.createSimple("org.hibernate.annotations.Parent"),
            DotName.createSimple("org.hibernate.annotations.PartitionKey"),
            DotName.createSimple("org.hibernate.annotations.Persister"),
            DotName.createSimple("org.hibernate.annotations.Polymorphism"),
            DotName.createSimple("org.hibernate.annotations.Proxy"),
            DotName.createSimple("org.hibernate.annotations.QueryCacheLayout"),
            DotName.createSimple("org.hibernate.annotations.RowId"),
            DotName.createSimple("org.hibernate.annotations.SQLDelete"),
            DotName.createSimple("org.hibernate.annotations.SQLDeleteAll"),
            DotName.createSimple("org.hibernate.annotations.SQLDeletes"),
            DotName.createSimple("org.hibernate.annotations.SQLInsert"),
            DotName.createSimple("org.hibernate.annotations.SQLInserts"),
            DotName.createSimple("org.hibernate.annotations.SQLJoinTableRestriction"),
            DotName.createSimple("org.hibernate.annotations.SQLOrder"),
            DotName.createSimple("org.hibernate.annotations.SQLRestriction"),
            DotName.createSimple("org.hibernate.annotations.SQLSelect"),
            DotName.createSimple("org.hibernate.annotations.SQLUpdate"),
            DotName.createSimple("org.hibernate.annotations.SQLUpdates"),
            DotName.createSimple("org.hibernate.annotations.SecondaryRow"),
            DotName.createSimple("org.hibernate.annotations.SecondaryRows"),
            DotName.createSimple("org.hibernate.annotations.SelectBeforeUpdate"),
            DotName.createSimple("org.hibernate.annotations.SoftDelete"),
            DotName.createSimple("org.hibernate.annotations.SortComparator"),
            DotName.createSimple("org.hibernate.annotations.SortNatural"),
            DotName.createSimple("org.hibernate.annotations.Source"),
            DotName.createSimple("org.hibernate.annotations.SqlFragmentAlias"),
            DotName.createSimple("org.hibernate.annotations.Struct"),
            DotName.createSimple("org.hibernate.annotations.Subselect"),
            DotName.createSimple("org.hibernate.annotations.Synchronize"),
            DotName.createSimple("org.hibernate.annotations.Table"),
            DotName.createSimple("org.hibernate.annotations.Tables"),
            DotName.createSimple("org.hibernate.annotations.Target"),
            DotName.createSimple("org.hibernate.annotations.TenantId"),
            DotName.createSimple("org.hibernate.annotations.TimeZoneColumn"),
            DotName.createSimple("org.hibernate.annotations.TimeZoneStorage"),
            DotName.createSimple("org.hibernate.annotations.Type"),
            DotName.createSimple("org.hibernate.annotations.TypeBinderType"),
            DotName.createSimple("org.hibernate.annotations.TypeRegistration"),
            DotName.createSimple("org.hibernate.annotations.TypeRegistrations"),
            DotName.createSimple("org.hibernate.annotations.UpdateTimestamp"),
            DotName.createSimple("org.hibernate.annotations.UuidGenerator"),
            DotName.createSimple("org.hibernate.annotations.ValueGenerationType"),
            DotName.createSimple("org.hibernate.annotations.View"),
            DotName.createSimple("org.hibernate.annotations.Where"),
            DotName.createSimple("org.hibernate.annotations.WhereJoinTable"));

    public static final List<DotName> ANNOTATED_WITH_INJECT_SERVICE = List.of(
            DotName.createSimple("org.hibernate.engine.jdbc.connections.internal.DatasourceConnectionProviderImpl"));

    public static final List<DotName> JPA_LISTENER_ANNOTATIONS = List.of(
            DotName.createSimple("jakarta.persistence.PostLoad"),
            DotName.createSimple("jakarta.persistence.PostPersist"),
            DotName.createSimple("jakarta.persistence.PostRemove"),
            DotName.createSimple("jakarta.persistence.PostUpdate"),
            DotName.createSimple("jakarta.persistence.PrePersist"),
            DotName.createSimple("jakarta.persistence.PreRemove"),
            DotName.createSimple("jakarta.persistence.PreUpdate"));

    public static final List<DotName> JDBC_JAVA_TYPES = List.of(
            DotName.createSimple("java.lang.Boolean"),
            DotName.createSimple("java.lang.Byte"),
            DotName.createSimple("java.lang.Character"),
            DotName.createSimple("java.lang.Class"),
            DotName.createSimple("java.lang.Double"),
            DotName.createSimple("java.lang.Float"),
            DotName.createSimple("java.lang.Integer"),
            DotName.createSimple("java.lang.Long"),
            DotName.createSimple("java.lang.Object"),
            DotName.createSimple("java.lang.Short"),
            DotName.createSimple("java.lang.String"),
            DotName.createSimple("java.math.BigDecimal"),
            DotName.createSimple("java.math.BigInteger"),
            DotName.createSimple("java.net.InetAddress"),
            DotName.createSimple("java.net.URL"),
            DotName.createSimple("java.sql.Blob"),
            DotName.createSimple("java.sql.Clob"),
            DotName.createSimple("java.sql.NClob"),
            DotName.createSimple("java.time.Duration"),
            DotName.createSimple("java.time.Instant"),
            DotName.createSimple("java.time.LocalDate"),
            DotName.createSimple("java.time.LocalDateTime"),
            DotName.createSimple("java.time.LocalTime"),
            DotName.createSimple("java.time.OffsetDateTime"),
            DotName.createSimple("java.time.OffsetTime"),
            DotName.createSimple("java.time.Year"),
            DotName.createSimple("java.time.ZoneId"),
            DotName.createSimple("java.time.ZoneOffset"),
            DotName.createSimple("java.time.ZonedDateTime"),
            DotName.createSimple("java.util.Calendar"),
            DotName.createSimple("java.util.Currency"),
            DotName.createSimple("java.util.Date"),
            DotName.createSimple("java.util.Locale"),
            DotName.createSimple("java.util.Map$Entry"),
            DotName.createSimple("java.util.TimeZone"),
            DotName.createSimple("java.util.UUID"),
            DotName.createSimple("java.lang.Void"));
}
