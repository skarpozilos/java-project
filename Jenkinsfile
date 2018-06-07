pipeline {
  agent any

  options {
    buildDiscarder(logRotator(numToKeepStr: '2', artifactNumToKeepStr: '1'))
  }
  
  stages {
    stage('Say Hello') {
        steps {
            sayHello 'Awesome Student!'
        }
    }
    stage('Git Information') {
        steps {
            echo "Branch Name: ${env.BRANCH_NAME}"
            echo "Workspace: ${env.WORKSPACE}"
            script{
                def myLib = new linuxacademy.git.gitStuff();
                echo "My Commit: ${myLib.gitCommit("${env.WORKSPACE}/.git")}"
            }
        }
    }
    stage('Unit Tests') {
	  steps {
	    sh 'ant -f test.xml -v'
		junit 'tests/reports/result.xml'
	  }
	}

    stage('build') {
      steps {
        sh 'ant -f build.xml -v'
      }
    }
  }
  
  post {
    always {
      archiveArtifacts artifacts: 'dist/*.jar', fingerprint: true
    }
  }
}
