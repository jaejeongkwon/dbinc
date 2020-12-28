#!/bin/bash
####################################################################################
#### Editor : jaejeongk@dbgroup.co.kr
#### Referance : Technology shared on the Internet
####             Thank you to the people who are competent.
#### script : control command for lena
#### Test: linux (centos7.x ,bash)
####################################################################################
#### LENA Manager - Log Performance View 
####################################################################################
############### script home set ###############
## setting script home. (don't modify them) ##

export SHOME=`pwd`
export CHK_HOME="";
PLHOME="";

CheckHome (){
## {LENA_Engine_HOME}
    if [ -d $SHOME/modules/lena-manager ]; then
        CHK_HOME=$SHOME
    fi
##{LENA_Engine_HOME}/etc/script
    if [ -f $SHOME/lena-service.template ]; then
        CHK_HOME=`cd ../..; pwd`
    fi
##{LENA_Engine_HOME}/bin
    if [ -f $SHOME/check-license.sh ]; then
        CHK_HOME=`cd ..; pwd`
    fi

export CHK_HOME

    if [ -z $CHK_HOME ] ; then
      echo "######## Check script Path!!! ########"
      echo "## {LENA_Engine_HOME}, {LENA_Engine_HOME}/bin, {LENA_Engine_HOME}/etc/script ###"
    fi
#   echo $CHK_HOME
}
### check home 
CheckHome

CheckVersion(){
for rli in `cat $CHK_HOME/etc/info/release-info.xml`
do
    if [[ $rli =~ "1.3.1" ]]; then
        PLHOME="$CHK_HOME/repository/monitoringDB/maintenance"
        break
    fi
    if [[ $rli =~ "1.3.0" ]]; then
        PLHOME="$CHK_HOME/database/maintenance"
        break
    fi
done
}


####################################################################################
############## home setting (don't modify them) ###
## version check 필요!!

if [ -d $CHK_HOME/modules/lena-manager ]; then
CheckVersion

    export JHOME=`cat $CHK_HOME/etc/info/java-home.info`

######################################################################################
## runtime view
    $JHOME/bin/java -jar $CHK_HOME/etc/script/lenaM-LogPerfV21-01.jar $PLHOME

######################################################################################
##### for logging view 
#####     $JHOME/bin/java -jar $CHK_HOME/etc/script/lenaM-LogPerfV21-01.jar $PLHOME {ALL|WAS|WEB|SESSION} {today|month} {today with -1(only)   | month with file index}
########## file selet view
# $JHOME/bin/java -jar $CHK_HOME/etc/script/lenaM-LogPerfV21-01.jar $PLHOME ALL month 9
########## today view
# $JHOME/bin/java -jar $CHK_HOME/etc/script/lenaM-LogPerfV21-01.jar $PLHOME WAS today -1
######################################################################################

fi

