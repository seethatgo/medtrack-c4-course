workspace "MedTrack" "Reference model for the C4 course" {

    model {
        patient = person "Patient" "Books appointments and requests prescription refills"
        staff = person "Clinic Staff" "Manages schedules and works the refill queue"

        medtrack = softwareSystem "MedTrack" "Patient appointment and prescription-refill platform" {
            mobileApp = container "Mobile App" "Patient-facing appointment and refill features" "React Native"
            webApp = container "Staff Web App" "Schedule management and refill queue" "React SPA"
            api = container "API Application" "Business logic, integrations, and orchestration" "Java / Spring Boot"
            db = container "Database" "Appointments, refill requests, audit log" "PostgreSQL" "Database"
        }

        ehr = softwareSystem "EHR System" "Electronic health record; source of truth for patient data" "External"
        pharmacy = softwareSystem "Pharmacy Network" "Receives approved refills; reports fill status" "External"
        sms = softwareSystem "SMS Provider" "Sends reminders and status texts" "External"
        eligibility = softwareSystem "Insurance Eligibility Service" "Real-time coverage checks" "External"

        patient -> mobileApp "Books appointments and requests refills using"
        staff -> webApp "Manages schedules and refill queue using"
        mobileApp -> api "Makes API calls to" "JSON/HTTPS"
        webApp -> api "Makes API calls to" "JSON/HTTPS"
        api -> db "Reads from and writes to" "JDBC"
        api -> ehr "Gets patient records and appointments of record from" "HL7 FHIR R4/HTTPS"
        api -> pharmacy "Submits approved refill requests to" "HTTPS"
        api -> sms "Sends reminders and status updates via" "HTTPS"
        api -> eligibility "Checks coverage with" "HTTPS"

        production = deploymentEnvironment "Production" {
            deploymentNode "Cloud" "" "Azure-flavored" {
                deploymentNode "Kubernetes Cluster" "" "Managed K8s" {
                    containerInstance api
                }
                deploymentNode "Managed PostgreSQL" "" "PaaS" {
                    containerInstance db
                }
            }
            deploymentNode "Clinic Data Center" "" "On-premises" {
                deploymentNode "EHR Gateway Server" "" "VM" {
                }
            }
            deploymentNode "Patient Device" "" "iOS/Android" {
                containerInstance mobileApp
            }
        }
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
        dynamic medtrack "RefillRequest" "Patient requests a prescription refill" {
            patient -> mobileApp "Requests refill"
            mobileApp -> api "POST /refill-requests"
            api -> eligibility "Checks coverage"
            api -> pharmacy "Submits approved refill"
            api -> sms "Sends status text"
            autoLayout
        }
        deployment medtrack "Production" "ProductionDeployment" {
            include *
            autoLayout
        }
        styles {
            element "Person" {
                shape person
                background #08427b
                color #ffffff
            }
            element "Container" {
                background #438dd5
                color #ffffff
            }
            element "Database" {
                shape cylinder
            }
            element "External" {
                background #999999
                color #ffffff
            }
            element "Software System" {
                background #1168bd
                color #ffffff
            }
        }
    }
}
