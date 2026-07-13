# Structurizr DSL — Reference

Run it at [structurizr.com/dsl](https://structurizr.com/dsl). Worked example: [`/dsl/reference-medtrack.dsl`](../dsl/reference-medtrack.dsl).

## Skeleton

```
workspace "Name" "Description" {
    model {
        // people, software systems, containers, components, relationships
    }
    views {
        // one view per diagram, plus styles
    }
}
```

## Model elements

```
patient = person "Patient" "Books appointments and requests refills"

medtrack = softwareSystem "MedTrack" "Appointment and refill platform" {
    api = container "API Application" "Business logic" "Java / Spring Boot"
    db  = container "Database" "Stores appointments and refills" "PostgreSQL" "Database"
}

ehr = softwareSystem "EHR System" "Patient records of record" "External"
```

- `person "Name" "Description"`
- `softwareSystem "Name" "Description" [tags]`
- `container "Name" "Description" "Technology" [tags]`
- `component "Name" "Description" "Technology" [tags]`
- The last string is a tag list; tags like `Database` or `External` drive styling.

## Relationships

```
a -> b "Verb phrase" "Technology"
```

Technology is optional, but every arrow needs a verb-phrase label.

## Tags and styles

```
styles {
    element "Person"   { shape person }
    element "Database" { shape cylinder }
    element "External" { background #999999 color #ffffff }
}
```

## Deployment

```
production = deploymentEnvironment "Production" {
    deploymentNode "Cloud" "" "Azure-flavored" {
        deploymentNode "Kubernetes Cluster" "" "Managed K8s" {
            containerInstance api
        }
    }
}
```

- `deploymentEnvironment "Name" { ... }`
- `deploymentNode "Name" "Description" "Technology" { ... }` (can nest)
- `containerInstance <id>` places a running copy of a container onto a node.

## Views

```
views {
    systemContext medtrack "Context" { include * autoLayout }
    container     medtrack "Containers" { include * autoLayout }
    component     api      "Components" { include * autoLayout }
    dynamic       medtrack "RefillRequest" "..." { /* ordered rels */ autoLayout }
    deployment    medtrack "Production" "ProductionDeployment" { include * autoLayout }
}
```

- `include *` pulls in everything relevant to that view's scope.
- `autoLayout` lets Structurizr position elements (unlike Mermaid, which uses statement order).
- View types: `systemContext`, `container`, `component`, `dynamic`, `deployment`.
