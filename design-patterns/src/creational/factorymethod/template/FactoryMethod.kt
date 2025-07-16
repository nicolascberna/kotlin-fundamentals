package creational.factorymethod.template

sealed class Country {
    data class Chile(val value: String): Country()
    data class Argentina(val value: String): Country()
    data object Brazil: Country()
}

data class Currency(val code: String)

object CurrencyFactory {
    fun currencyForCountry(country: Country): Currency =
        when(country) {
            is Country.Chile -> Currency("CLP")
            is Country.Argentina -> Currency("ARP")
            is Country.Brazil -> Currency("BRL")
        }
}

fun main() {
    val chileanCurrency = CurrencyFactory.currencyForCountry(Country.Chile(""))
    println(chileanCurrency.code)
}