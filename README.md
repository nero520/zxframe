# zxframe JAVA框架
*.支持JPA：继承hibernate的便捷操作和mybatis的sql集中编写or管理；支持乐观锁<br/>
*.支持多层次缓存：本地一级缓存，本地全局二级缓存，远程缓存，查询缓存，方法级别缓存<br/>
*.支持缓存融入事务，业务异常不提交缓存数据<br/>
*.支持防缓存穿透和防缓存击穿<br/>
*.支持DB多数据源：分库分表，读写分离，多读数据源熔断<br/>
*.支持DB数据源监控<br/>
*.支持通用分布式锁<br/>
*.支持全服务热更新配置<br/>
-->SpringCloudConfigServer高可用成本较高，运维成本提升<br/>
-->本功能只为降低成本，可选用<br/>
*.封装本地和远程任意缓存存储,使用极其简单,支持对缓存组删除<br/>
-->zxframe.cache.local.LocalCacheManager<br/>
-->zxframe.cache.redis.RedisCacheManager<br/>
