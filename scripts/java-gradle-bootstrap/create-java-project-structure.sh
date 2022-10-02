echo "Creating Project with Name:" $1

MAIN_JAVA_FOLDER=$1/src/main/java
echo "Main Java Folder: $MAIN_JAVA_FOLDER"

mkdir -p $1/src/main/java
echo "src/main/java folder created"

mkdir -p $1/src/test/java
echo "src/test/java folder created"

mkdir -p $1/src/main/resources
echo "src/main/resources folder created"


mkdir -p $1/src/test/resources
echo "src/test/resources folder created"

BUILD_GRADLE_PATH=$1/build.gradle

echo "#Adding build.gradle code here" > $BUILD_GRADLE_PATH
echo "#Adding settings.gradle code here" > $1/settings.gradle
echo "#Adding README content here" > $1/README.md

echo "Package Name: $2"

IFS='.' read -ra ADDR <<< "$2"

for i in "${ADDR[@]}"; do
  mkdir $MAIN_JAVA_FOLDER/$i
  echo "Directory created by appending $i"
  MAIN_JAVA_FOLDER=$MAIN_JAVA_FOLDER/$i
  echo "New main java folder:$MAIN_JAVA_FOLDER"
done


cp build-template.gradle $BUILD_GRADLE_PATH
echo "Build Gradle Template copied"

#https://mkyong.com/mac/sed-command-hits-undefined-label-error-on-mac-os-x/
sed -i '' "s/{package_name}/$2/g" $BUILD_GRADLE_PATH
