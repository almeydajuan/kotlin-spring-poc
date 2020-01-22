dependencies-up-compose = docker-compose -f docker/dependencies.yml

dependencies:
	$(dependencies-up-compose) up -d
