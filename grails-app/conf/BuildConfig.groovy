grails.servlet.version = "3.0" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"

//..some other configuration


grails.project.dependency.resolution = {

//..some other configuration and blocks

    plugins {
        //.. other plugins
        compile ":quick-search"
    }
}
