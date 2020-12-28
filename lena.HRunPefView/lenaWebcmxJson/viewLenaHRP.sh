#!/bin/bash
####################################################################################
#### Editor : jaejeongk@dbgroup.co.kr
#### Referance : Technology shared on the Internet
####             Thank you to the people who are competent.
#### script : Perfermance read command for lena
#### Test: linux (centos,bash)
####################################################################################
#### LENA HTTP - Runtime Performance View 
####################################################################################
############### script home set ###############
## setting script home. (don't modify them) ##

export SHOME=`pwd`
export CHK_HOME="";
scopev="ALL"

CheckHome (){
## {LENA_Engine_HOME}
    if [ -d $SHOME/modules/lena-web-pe ]; then
        CHK_HOME=$SHOME
        PLHOME="$CHK_HOME/servers"
    fi
##{LENA_Engine_HOME}/etc/script
    if [ -f $SHOME/lena-service.template ]; then
        CHK_HOME=`cd ../..; pwd`
        PLHOME="$CHK_HOME/servers"
    fi
##{LENA_Engine_HOME}/bin
    if [ -f $SHOME/check-license.sh ]; then
        CHK_HOME=`cd ..; pwd`
        PLHOME="$CHK_HOME/servers"
    fi
####
##{LENA_Engine_HOME}/servers/{http instance}/bin
    if [ -f $SHOME/print-env.sh ]; then
        CHK_HOME=`cd ../../..; pwd`
        PLHOME=`cd ..; pwd`
        scopev="instance"
    fi

##{LENA_Engine_HOME}/servers/{http instance}
    if [ -d $SHOME/conf/extra ]; then
        CHK_HOME=`cd ../..; pwd`
        PLHOME=$SHOME
        scopev="instance"
    fi

export CHK_HOME
export PLHOME
export scopev

    if [ -z $CHK_HOME ] ; then
      echo "######## Check script Path!!! ########"
      echo "## {LENA_Engine_HOME}, {LENA_Engine_HOME}/bin, {LENA_Engine_HOME}/etc/script ###"
      echo "## {LENA_Engine_HOME}/servers/{instance}, {LENA_Engine_HOME}/servers/{instance}/bin ###"
      echo "#### Please edit the other path individually! --> CHK_HOME ###"
    fi
#   echo $CHK_HOME
}
### check home 
CheckHome
####################################################################################
############## run setting (don't modify them) ###

viewRuntime(){
  export JHOME=`cat $CHK_HOME/etc/info/java-home.info`
  $JHOME/bin/java -jar $CHK_HOME/etc/script/lenaH-RunPerfV21-01.jar $SERVER_ID $SERVICE_PORT $1
}

## {LENA_Engine_HOME} ~
if [ $scopev == "ALL" ]; then
    ISL=`ls -F $PLHOME | grep / |tr -d /`
    
    for sl in $ISL
    do
        . $PLHOME/$sl/env.sh;
        viewRuntime $PLHOME/$sl/conf/extra/workers.properties
    done
else
    . $PLHOME/env.sh;
    viewRuntime $PLHOME/$sl/conf/extra/workers.properties
fi
