def call(){
	pipeline { 
		agent any
		tools {
			maven 'Maven3'
		}
		stages { 
			stage ('Initialize') {
				steps {
					sh '''
						echo "PATH = ${PATH}"
						echo "M2_HOME = ${M2_HOME}"
					'''
				}
			}
			stage('Build with java 9') { 
				steps {
					withMaven(jdk:'java-9') {
						sh 'mvn clean verify' 
					}
				}
			}
			stage('Build with java 8') { 
				steps {
					withMaven(jdk:'java-8') {
						sh 'mvn clean verify' 
					}
				}
			}
		}
	}
}
