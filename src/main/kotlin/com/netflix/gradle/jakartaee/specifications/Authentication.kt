/*
 * Copyright 2022 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.netflix.gradle.jakartaee.specifications

import com.netflix.gradle.jakartaee.artifacts.ArtifactCoordinate
import com.netflix.gradle.jakartaee.artifacts.ArtifactVersion

internal class Authentication : ContainerProvidedSpecification(
    "auth.message-api",
    JAVAX,
    JAVAX_COORDINATES,
    JAKARTA,
    JAKARTA_COORDINATES,
    SPECIFICATION_TO_AUTH_VERSION
) {
    companion object {
        private val GLASSFISH = ArtifactCoordinate("org.glassfish", "javax.security.auth.message") // Repackaged OSGi bundle, appears to be EE 6
        private val JAVAX = ArtifactCoordinate("javax.security.auth.message", "javax.security.auth.message-api") // 1.0 through 1.1.1
        private val JAKARTA_LEGACY = ArtifactCoordinate("jakarta.security.auth.message", "jakarta.security.auth.message-api") // 1.1.2 through 1.1.3
        private val JAKARTA = ArtifactCoordinate("jakarta.authentication", "jakarta.authentication-api") // 2.0.0 and later

        private val TOMCAT = ArtifactCoordinate("org.apache.tomcat", "tomcat-jaspic-api") // 8.5 and later

        private val SPECIFICATION_TO_AUTH_VERSION = mapOf(
            SpecificationVersion.EE8 to ArtifactVersion("1.1.0"),
            SpecificationVersion.EE9 to ArtifactVersion("2.0.0"),
            SpecificationVersion.EE9_1 to ArtifactVersion("2.0.0"),
            SpecificationVersion.EE10 to ArtifactVersion("3.0.0"),
        )

        private val JAVAX_COORDINATES = listOf(
            GLASSFISH,
            TOMCAT,
            JAVAX,
        )

        private val JAKARTA_COORDINATES = listOf(
            JAKARTA_LEGACY,
            JAKARTA,
            TOMCAT_EMBED
        )
    }
}
