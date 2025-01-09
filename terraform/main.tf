terraform {
  required_providers {
    docker = {
      source  = "kreuzwerker/docker"
      version = "~> 3.0.1"
    }
  }
}

provider "docker" {
  host = "npipe:////.//pipe//docker_engine"
}

resource "docker_volume" "db" {
  name = "db"
}

resource "docker_image" "postgres" {
  name = "postgres:17"
}

resource "docker_container" "postgres" {
  image = docker_image.postgres.image_id
  name  = "trussdb"
  env   = ["POSTGRES_USER=postgres", "POSTGRES_PASSWORD=devPass123", "POSTGRES_DB=trussdb"]
  volumes {
    volume_name    = docker_volume.db.name
    container_path = "/var/lib/postgresql/data"
  }
  ports {
    internal = "5432"
    external = "5432"
  }
}