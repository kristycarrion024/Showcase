#! /usr/bin/perl -w
# Author: Kristy Carrion
# Date: 04/15/2013
#
# A Perl script that implements a simple version of tail.
#
# Exit Status 0: Success!

use strict;
use warnings;

my $lines = 10;

# Checks argument 0 for a number.
if (@ARGV > 0 && $ARGV[0] =~ m/^-\d+/)
{
    $lines = substr($ARGV[0], 1);
    if ($lines lt 1)
    {
        $lines = 10;
    }
   shift;
}

# Handles the case where there are no file arguments.
if (@ARGV == 0)
{
    # Removes newlines generated by standard in.
    chomp(my @file = <>);
    my $numlines = $lines < @file ? $lines : @file;
    # Find and prints the last 10 lines from standard in, or if less then or
    # equal to 10, it will print all of the lines.
    for (my $j = -1 * $numlines; $j <= -1; $j++)
    {
        print "$file[$j]\n";
    }
}
# Handles the case where there are 1 or more file arguments.
else
{
    for (my $i = 0; $i < @ARGV; $i++)
    {
        open IN, "<", "$ARGV[$i]";
        # If we are dealing with more than 1 argument, print the names.
        if (@ARGV > 1)
        {
            print "===> $ARGV[$i] <===\n";
        }
        chomp(my @file = <IN>);
        my $numlines = $lines < @file ? $lines : @file;
        # Spit the last n lines out.
        for (my $j = -1 * $numlines; $j <= -1; $j++)
        {
            print "$file[$j]\n";
        }
        close IN;
    }
}

# Exits successfully.
exit 0;