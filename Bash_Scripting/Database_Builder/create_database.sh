#! /bin/bash

# Author: Kristy Carrion
# Date: 03/03/2013
#
# The purpose of this program is to create a database. The program expects only
# two arguments a template name and a database name, otherwise it will print a 
# usage message. This program checks that the given template name exists and 
# then checks to see that the database name does not exist.
# The program will append the information of the created database to 
# the database list file.
#
# Exit Status:
#
#

readonly EXIT_SUCCESS=0
readonly INCORRECT_ARGS=1
readonly FILE_EXISTS_PERMISSIONS=2
readonly FILE_DNE=3
readonly MULT_COPIES=4
readonly UNABLE_FIND_CREATE=5

readonly CORRECT_ARGS=2

# Checks for correct arguments and exits with error if they are incorrect.
if ! [ "$#" -eq $CORRECT_ARGS ]; then
    echo "Error: Incorrect number of arguments: $#"
    echo "Usage: $0 <Template_Name> <Database_Name>"
    exit $INCORRECT_ARGS
fi

# Attemps to find the template file. It will exit with error and print 
# the error messages created by find_template_file.sh if it is unsuccessful.
template_file_name=`./find_template_file.sh`
error=$?
if ! [ "$error" = $EXIT_SUCCESS ]; then
    echo "$template_file_name"
    exit $UNABLE_FIND_CREATE
fi

#Checks template file for read permissions. Exit with error if incorrect.
template_perm=`./permissions_helper.sh $template_file_name r`
error=$?
if [ "$error" = $FILE_EXISTS_PERMISSIONS ]; then
    echo "$template_perm"
    echo "Could not read the template file. Please adjust the filesystem."
    exit $FILE_EXISTS_PERMISSIONS
fi

# This block quickly searches through the input received by template_file_name.
# It prints any error messages, and saves the last line (the name of the
# template file)
temp_IFS=$IFS
IFS=$'\n'
error_message=""
next_part=""
count=0
for line in $template_file_name
do
    error_message="$error_message $next_part"
    next_part="$line"
    count=`expr $count + 1`
done
if [ $count -gt 1 ]; then
    #Special quick awk script specifically for removing the leading whitespace.
    echo "$error_message" | awk '{print substr($0, 3, 1000)}'
fi
IFS=$temp_IFS
template_file_name=$next_part

# Checks if the template actually exists. If it does not, exits with error.
exists=`./template_exists.sh $template_file_name $1`
success="$?"
if ! [ "$success" -eq 0 ]; then
    echo "Error: $exists"
    exit $MULT_COPIES
fi

# Evaluates if the database already exists. If the database file does not exist,
# it will be created and the database will be created and added to it. If 
# the database does exist we exit with error. If it does not, we exit with
# success after creating the database.
output_file="databases.txt" 
output=`./database_exists.sh $2 $output_file`
error=$?
echo $output
if [ "$error" = $FILE_DNE ]; then
    toAppend="$2 $1"
    echo "$toAppend" >> "$output_file"
    newfile="$2.db"
    touch $newfile
    echo "Database "$2" using template "$1" has been created."
    exit $EXIT_SUCCESS
fi
permissions=`./permissions_helper.sh $output_file r w`
error=$?
if  [ $error = $FILE_EXISTS_PERMISSIONS ]; then
    echo $error
    echo "$permissions"
    echo "Please adjust the filesystem accordingly."
    exit $FILE_EXISTS_PERMISSIONS
fi
if [ "$error" = $EXIT_SUCCESS ]; then
    echo "Error: Database $2 already exists."
    exit $MULT_COPIES
else
    echo $output
    exit $MULT_COPIES
fi
