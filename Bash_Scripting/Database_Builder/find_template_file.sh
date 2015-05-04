#!/bin/bash 
#
# Author: Kristy Carrion
# Date: 03/04/2013
# 
# This script attempts to find the template definition file in the local directory.
# It does not look in hidden lower directories. If any files are unreadable
# the program will error, because it is possible that the template definition
# file is unreadable. If no match is found, this script will create one.
# If the name template.dat is taken in this case, but is not the template file,
# this program will error instead. It will also error if there are more than 
# one template definition files found, but will print the names of those 
# files. If the template definition file is found (or created), this script will
# return the name of that file.
#
# Exit Codes:
#
# 0: Success! [EXIT_SUCCESS]
# 2: File exists but does not have correct permissions. 
#    [FILE_EXISTS_PERMISSIONS]
# 4: More than one of the specified files exist.  [MULTI_COPIES]
# 6: This directory contains files that this program cannot read. 
#    [UNREADABLE_FILES]
# 7: File exists but is not a template file, error. [FILE_EXISTS_WITH_ERROR]
# Please see README.txt for more Exit statuses.

readonly EXIT_SUCCESS=0
readonly FILE_EXISTS_PERMISSIONS=2
readonly MULTI_COPIES=4
readonly UNREADABLE_FILES=6
readonly FILE_EXISTS_WITH_ERROR=7

# Finds every file in this directory, but excludes directories. If this script
# finds a file without read permission, it will exit with error, because 
# it is possible for that file to be the template definition file. 
success=0
files=`find . -maxdepth 1 -type f`
for f in $files
do
    permissions=$(./permissions_helper.sh $f r)
    if ! [ "$?" = 0 ]; then
        echo "$permissions"
        echo "Please adjust permissions in this directory. The database file" 
        echo "might be unreadable."
        exit $UNREADABLE_FILES #6
    fi
done

# This part uses an accompanying awk script to iterate over every file found
# and search for the correct indicator "templateFile definition" at the top of
# each file. It will catch the name of every file that contains the indicating
# phrase. It also keeps a counter of the number of files found containing the
# phrase.
new_files=""
count=0
for f in $files
do
    temp_file="$(awk -f find_template_file.awk $f)" 
    if ! [ "$temp_file" = "" ]; then
        count=`expr $count + 1`
        new_files="$new_files $temp_file"
    fi
done

# Evaluates the number of files found, and acts appropriately. A new template 
# file will be created and properly appended with "templateFile definition" in 
# the event that there is no existing template definition file. It will error
# if it tries to create the file, but there already exists a template.dat.
# Otherwise, if multiple template definition files are found. If the file is 
# found, this script will exit without error.
if [ "$count" = 0 ]; then
    printf "No template file exists.\nCreating template.dat...\n"
    permissions=$(./permissions_helper.sh template.dat)
    error=$?
    # If file exists, but was not the template file, then we can not create a
    # new one over top of it. Exit with error.
    if  [ "$error" = $EXIT_SUCCESS ]; then
        echo "template.dat already exists, but is not the template file. Please"
        echo "delete template.dat or create a new template file."
        exit $FILE_EXISTS_WITH_ERROR #7
    else
        echo "templateFile definition" > template.dat
        echo "template.dat"
        exit $EXIT_SUCCESS #0
    fi
else
    if [ "$count" -gt 1 ]; then
        echo "Multiple template files found:" 
        for f in $new_files
        do
            echo `basename $f`
        done
        echo "Please delete all but the current template file."
        exit $MULTI_COPIES #4
    else
        echo "`basename $new_files`"
        exit $EXIT_SUCCESS #0
    fi
fi
