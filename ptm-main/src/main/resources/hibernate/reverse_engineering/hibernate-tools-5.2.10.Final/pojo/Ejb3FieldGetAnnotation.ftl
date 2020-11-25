<#if ejb3>
<#if pojo.hasIdentifierProperty()>
<#if field.equals(clazz.identifierProperty)>
 ${pojo.generateAnnIdGenerator()}
<#-- if this is the id field (getter)-->
<#-- explicitly set the column name for this field-->
</#if>
</#if>

<#if c2h.isOneToOne(field)>
${pojo.generateOneToOneAnnotation(field, md)}
<#elseif c2h.isManyToOne(field)>
${pojo.generateManyToOneAnnotation(field)}
<#--TODO support optional and targetEntity-->    
${pojo.generateJoinColumnsAnnotation(field, md)}
<#elseif c2h.isCollection(field)>
${pojo.generateCollectionAnnotation(field, md)}
<#else>
${pojo.generateBasicAnnotation(field)}
${pojo.generateAnnColumnAnnotation(field)}
<#if field.name == "createdOn">
@${pojo.importType("org.hibernate.annotations.CreationTimestamp")}
</#if>
<#if field.name == "updatedOn">
@${pojo.importType("org.hibernate.annotations.UpdateTimestamp")}
</#if>
</#if>
</#if>