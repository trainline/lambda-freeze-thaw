(defproject com.trainline/freeze-thaw "0.1.0"
  :description "Test project to demonstrate Freeze&Thaw behaviour in AWS Lambdas"
  :url "http://example.com/FIXME"
  :license {:name "Apache License 2.0"
            :url "http://www.apache.org/licenses/LICENSE-2.0"}
  :profiles {:uberjar {:aot :all}}

  :java-source-paths ["src/java/main"]

  :main com.trainline.freezethaw.FreezeThawLambda

  :dependencies [[com.amazonaws/aws-java-sdk-core "1.11.26"]
                 [com.amazonaws/aws-lambda-java-core "1.1.0"]
                 [com.amazonaws/aws-lambda-java-log4j "1.0.0"]
                 [log4j/log4j "1.2.17" :exclusions [javax.mail/mail
                                                    javax.jms/jms
                                                    com.sun.jdmk/jmxtools
                                                    com.sun.jmx/jmxri]]])
