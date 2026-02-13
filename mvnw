#!/bin/sh
# ----------------------------------------------------------------------------
# Licensed to the Apache Software Foundation (ASF) under one
# or more contributor license agreements.  See the NOTICE file
# distributed with this work for additional information
# regarding copyright ownership.  The ASF licenses this file
# to you under the Apache License, Version 2.0 (the
# "License"); you may not use this file except in compliance
# with the License.  You may obtain a copy of the License at
#
#    http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing,
# software distributed under the License is distributed on an
# "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
# KIND, either express or implied.  See the License for the
# specific language governing permissions and limitations
# under the License.
# ----------------------------------------------------------------------------

# ----------------------------------------------------------------------------
# Maven Wrapper startup batch script, version 3.2.0
#
# Optional ENV vars
# -----------------
#   JAVA_HOME - Java installation directory
#   MAVEN_OPTS - parameters passed to the Java VM when running Maven
#     e.g. to debug Maven itself, use
#       set MAVEN_OPTS=-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=8000
#   MAVEN_SKIP_RC - flag to disable loading of mavenrc files
# ----------------------------------------------------------------------------

if [ -z "$MAVEN_SKIP_RC" ] ; then
  if [ -f /etc/mavenrc ] ; then
    . /etc/mavenrc
  fi
  if [ -f "$HOME/.mavenrc" ] ; then
    . "$HOME/.mavenrc"
  fi
fi

# OS specific support. $var _must_ be set to either true or false.
cygwin=false;
darwin=false;
mingw=false;
case "`uname`" in
  CYGWIN*) cygwin=true ;;
  Darwin*) darwin=true ;;
  MINGW*) mingw=true ;;
esac

# Resolve the location of the script
PRG="$0"
while [ -h "$PRG" ]; do
  ls=`ls -ld "$PRG"`
  link=`expr "$ls" : '.*-> \(.*\)$'`
  if expr "$link" : '/.*' > /dev/null; then
    PRG="$link"
  else
    PRG=`dirname "$PRG"`/"$link"
  fi
done
SAVED="`pwd`"
cd "`dirname \"$PRG\"`/" >/dev/null
MAVEN_PROJECTBASEDIR=`pwd`
cd "$SAVED" >/dev/null

if [ -z "$JAVA_HOME" ] ; then
  if [ -r /etc/gentoo-release ] ; then
    JAVA_HOME=`java-config --jre-home`
  fi
fi

if [ -z "$JAVA_HOME" ] ; then
  if $darwin ; then
    if [ -x /usr/libexec/java_home ] ; then
      JAVA_HOME=`/usr/libexec/java_home`
    fi
  fi
fi

if [ -z "$JAVA_HOME" ] ; then
  if [ -x /usr/bin/java ] ; then
    JAVA_HOME=`java -XshowSettings:properties -version 2>&1 | grep "java.home" | awk '{print $3}'`
  fi
fi

if [ -z "$JAVA_HOME" ] ; then
  echo "Error: JAVA_HOME is not defined."
  exit 1
fi

JAVA_EXE="$JAVA_HOME/bin/java"
if [ ! -x "$JAVA_EXE" ] ; then
  echo "Error: JAVA_EXE not found."
  exit 1
fi

WRAPPER_JAR="$MAVEN_PROJECTBASEDIR/.mvn/wrapper/maven-wrapper.jar"
WRAPPER_PROPERTIES="$MAVEN_PROJECTBASEDIR/.mvn/wrapper/maven-wrapper.properties"
LAUNCHER_CLASS="org.apache.maven.wrapper.MavenWrapperMain"

if [ ! -f "$WRAPPER_JAR" ]; then
    echo "Couldn't find .mvn/wrapper/maven-wrapper.jar, downloading it ..."
    JAR_URL=$(grep "^wrapperUrl=" "$WRAPPER_PROPERTIES" | cut -d'=' -f2-)
    if [ -z "$JAR_URL" ]; then
        JAR_URL="https://repo.maven.apache.org/maven2/org/apache/maven/wrapper/maven-wrapper/3.2.0/maven-wrapper-3.2.0.jar"
    fi
    curl -sfLo "$WRAPPER_JAR" "$JAR_URL" || wget -q -O "$WRAPPER_JAR" "$JAR_URL"
fi

exec "$JAVA_EXE" \
  $MAVEN_OPTS \
  -classpath "$WRAPPER_JAR" \
  "-Dmaven.multiModuleProjectDirectory=$MAVEN_PROJECTBASEDIR" \
  "$LAUNCHER_CLASS" \
  "$@"
