FROM payara/server-web:7.2026.6
COPY target/jakartaee-hello-world.war $DEPLOY_DIR
