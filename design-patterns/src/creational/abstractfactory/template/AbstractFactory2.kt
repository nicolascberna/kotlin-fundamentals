package creational.abstractfactory.template

import utils.getOSName
import java.util.*

interface Button {
     fun paint()
}

interface Checkbox {
    fun paint()
}

class MacOSButton: Button {
    override fun paint() {
        println("You have created MacOSButton")
    }
}

class WindowsButton: Button {
    override fun paint() {
        println("You have created WindowsButton")
    }
}

class MacOSCheckbox: Checkbox {
    override fun paint() {
        println("You have created MacOSCheckbox")
    }
}

class WindowsCheckbox: Checkbox {
    override fun paint() {
        println("You have created WindowsCheckbox")
    }
}

interface GUIFactory {
    fun createButton(): Button
    fun createCheckbox(): Checkbox
}

class MacOSFactory: GUIFactory {
    override fun createButton(): Button = MacOSButton()
    override fun createCheckbox(): Checkbox = MacOSCheckbox()
}

class WindowsFactory: GUIFactory {
    override fun createButton(): Button = WindowsButton()
    override fun createCheckbox(): Checkbox = WindowsCheckbox()
}

data class Application(private var factory: GUIFactory) {
    fun paint() {
        factory.createButton().paint()
        factory.createCheckbox().paint()
    }
}

fun configureApplication(): Application {
    val factory = if (getOSName().contains("windows")) WindowsFactory() else MacOSFactory()
    return Application(factory)
}

fun main() {
    val app = configureApplication()
    app.paint()
}
