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

internal class XmlBind : BasicSpecification(
    "xml.bind-api",
    JAVAX,
    JAVAX_COORDINATES,
    JAKARTA,
    JAKARTA_COORDINATES,
    SPECIFICATION_TO_XML_BIND_VERSION
) {
    companion object {
        private val GLASSFISH = ArtifactCoordinate("org.glassfish", "javax.xml.bind") // Repackaged OSGi bundle, appears to be EE 6
        private val JAVAX_LEGACY = ArtifactCoordinate("javax.xml", "jaxb-api") // 1.0.1, 1.0.5, 2.0, 2.1. 2.0 relocates to javax.xml.bind
        private val JAVAX = ArtifactCoordinate("javax.xml.bind","jaxb-api") // 1.0 through 2.3.1
        private val JAVAX_OSGI = ArtifactCoordinate("javax.xml.bind","jaxb-api-osgi") // 2.2.1 through 2.2.7
        private val JAKARTA = ArtifactCoordinate("jakarta.xml.bind","jakarta.xml.bind-api") // 2.3.2 and later

        private val SPECIFICATION_TO_XML_BIND_VERSION = mapOf(
            SpecificationVersion.EE7 to ArtifactVersion("2.2.0"),
            SpecificationVersion.EE8 to ArtifactVersion("2.3.0"),
            SpecificationVersion.EE9 to ArtifactVersion("3.0.0"),
            SpecificationVersion.EE9_1 to ArtifactVersion("3.0.0"),
            SpecificationVersion.EE10 to ArtifactVersion("4.0.0"),
        )

        private val JAVAX_COORDINATES = listOf(
            GLASSFISH,
            JAVAX_LEGACY,
            JAVAX,
            JAVAX_OSGI,
        )

        private val JAKARTA_COORDINATES = listOf(
            JAKARTA,
        )
    }
}
