import org.gradle.api.tasks.wrapper.Wrapper.DistributionType.ALL

subprojects {
	tasks {
		register("allConfigurationDependencies") {
			notCompatibleWithConfigurationCache("incompatible")
			doLast {
				project.configurations.forEach { conf ->
					conf.allDependencies.forEach { dep ->
						println("${conf.name}:\t${dep.name}")
					}
				}
			}
		}
	}
}

tasks {
	named<Wrapper>("wrapper").configure {
		gradleVersion = "8.1-rc-3"
		distributionType = ALL
	}
}
