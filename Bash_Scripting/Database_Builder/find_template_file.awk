# Author: Kristy Carrion
# Date: 03/03/2013
#
# Quick awk script. This awk script matches only the first line in a file, and
# will print the name of the file if the phrase "templateFile definition" is the
# first line of the file, anchored to the front and end of the line.
{
    if ( NR == 1 && $0 ~/^templateFile definition$/)
    {
        print FILENAME
    }
}
