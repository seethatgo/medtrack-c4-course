workspace "MedTrack — Team __" "Exercise 5 starter" {

    model {
        // 1. PEOPLE — syntax: identifier = person "Name" "Description"
        patient = person "Patient" "Books appointments and requests refills"
        // TODO: add Clinic Staff

        // 2. YOUR SYSTEM and its CONTAINERS
        medtrack = softwareSystem "MedTrack" "Appointment and refill platform" {
            // syntax: id = container "Name" "Description" "Technology"
            // TODO: add YOUR containers from your Day 1 design, e.g.:
            // api = container "API Application" "Business logic" "Java / Spring Boot"
            // db = container "Database" "Stores appointments and refills" "PostgreSQL" "Database"
        }

        // 3. EXTERNAL SYSTEMS — tag "External" makes them gray
        ehr = softwareSystem "EHR System" "Patient records of record" "External"
        // TODO: Pharmacy Network, SMS Provider, Insurance Eligibility Service

        // 4. RELATIONSHIPS — syntax: a -> b "Verb phrase" "Technology"
        // Every arrow gets a verb. Example:
        // patient -> mobileApp "Books appointments using"
        // api -> ehr "Gets patient records from" "HL7 FHIR R4/HTTPS"
    }

    views {
        systemContext medtrack "Context" {
            include *
            autoLayout
        }
        container medtrack "Containers" {
            include *
            autoLayout
        }
        styles {
            element "Person" {
                shape person
            }
            element "Database" {
                shape cylinder
            }
            element "External" {
                background #999999
                color #ffffff
            }
        }
    }
}
