package creational.abstractfactory.template

interface DataSource

class DatabaseDataSource: DataSource

class NetworkDataSource: DataSource

abstract class DataSourceFactory {

    abstract fun makeDataSource(): DataSource

    companion object {
        inline fun <reified T: DataSource> createFactory(): DataSourceFactory =
            when (T::class) {
                DatabaseDataSource::class -> DatabaseFactory()
                NetworkDataSource::class -> NetworkFactory()
                else -> throw IllegalArgumentException()
            }
    }
}

class DatabaseFactory: DataSourceFactory() {
    override fun makeDataSource(): DataSource = DatabaseDataSource()

}

class NetworkFactory: DataSourceFactory() {
    override fun makeDataSource(): DataSource = NetworkDataSource()
}