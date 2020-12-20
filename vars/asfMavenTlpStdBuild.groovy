def call(){
  pipeline { 
    agent any  
    stages { 
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
