pipeline {
   agent any
   environment{
       password = credentials('cf-creds')
   }
   stages {
       stage('Build') {
           steps {
               echo 'Building Application: account...'
               sh './gradlew -p applications/account/'
               echo 'Building Application: order...'
               sh './gradlew -p applications/order/'
               echo 'Building Application: product...'
               sh './gradlew -p applications/product/'
               echo 'Building Application: shipment...'
               sh './gradlew -p applications/shipment/'
           }
       }
       stage('Deploy') {
           steps {
               echo 'Logging in to CF...'
               sh 'cf login -a https://api.run.pivotal.io -u jshelton@solstice.com -p $password -o solstice-org -s jshelton-cnt'
               echo 'Deploying....'

               sh 'cf push accounts --random-route -p applications/account/build/libs/accounts-0.0.1-SNAPSHOT.jar'
               sh 'cf push orders --random-route -p applications/order/build/libs/orders-0.0.1-SNAPSHOT.jar'
               sh 'cf push products --random-route -p applications/product/build/libs/products-0.0.1-SNAPSHOT.jar'
               sh 'cf push shipments --random-route -p applications/shipment/build/libs/shipments-0.0.1-SNAPSHOT.jar'
           }
       }
   }
}
