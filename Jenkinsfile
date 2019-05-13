pipeline {

    /*
     * Run everything on an existing agent configured with a label 'docker'.
     * This agent will need docker, git and a jdk installed at a minimum.
     */
//    agent {
//        node {
//            label 'docker'
//        }
//    }

    agent any

    // using the Timestamper plugin we can add timestamps to the console log
    options {
        timestamps()
    }

    tools {
        maven 'maven_3.6.1'
    }

    environment {

        // Get the Maven tool.
        // ** NOTE: This 'maven_3.6.1' Maven tool must be configured
        // **       in the global configuration.
        // mvnHome = tool 'maven_3.6.1'
        // Use Pipeline Utility Steps plugin to read information from pom.xml into env variables
        ARTIFACT_ID = readMavenPom().getArtifactId()
        VERSION = readMavenPom().getVersion()
    }

    stages  {
        stage('Preparation') { // for display purposes
            steps{
                // Get some code from a GitHub repository
                git 'https://github.com/dhananjay12/ci-cd-spring-project.git'
            }
        }
        stage('Build') {
            steps{
                //sh "'${mvnHome}/bin/mvn' clean install"
                sh "mvn clean install"
                sh "docker tag dhananjay12/${ARTIFACT_ID}:latest dhananjay12/${ARTIFACT_ID}:${VERSION}"
            }
        }
        stage('Results') {
            steps{
                junit '**/target/surefire-reports/TEST-*.xml'
            }
        }

        stage('Push image') {
            steps{
                /*
                You would need to first register with DockerHub before you can push images to your account
            */
                withRegistry('https://registry.hub.docker.com', 'docker-hub') {
                    sh "docker push dhananjay12/${ARTIFACT_ID}:${VERSION}"
                    sh "docker push dhananjay12/${ARTIFACT_ID}:latest"
                }
                echo "Trying to Push Docker Build to DockerHub"
            }

        }
    }

    post {
        failure {
            echo "Job Failed"
            // notify users when the Pipeline fails
//            mail to: 'team@example.com',
//                    subject: "Failed Pipeline: ${currentBuild.fullDisplayName}",
//                    body: "Something is wrong with ${env.BUILD_URL}"
        }
    }
}