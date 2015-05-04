#! /usr/bin/perl -w
# Author: Kristy Carrion
# Date: 04/15/2013
#
# A Perl script that implements a simple version of more.
#
# Exit Status 0: Success!

use strict;
use warnings;

# Size of the rows and cols of the terminal.
my $rows;
my $cols;

# Query size of terminal, split into two parts.
($rows, $cols) = split(/ /,`/bin/stty size`);
$rows -= 1; # Reduce row size to allow for vertical line
my $line;
my @page;
my $linecount = 0;

# While we still receive lines.
do
{
    # Try to read in 15 lines.
    for (my $i = 0; $i < 15; $i++)
    {
        $line = <>;
        if (!defined $line)
        {
            last;
        }
        $page[$i] = $line;
    }
    # Print out our lines as they come.
    for (my $j = 0; $j < @page; $j++)
    {
        chomp($page[$j]);
        print $page[$j];
        $linecount += 1;
        if (@page >= 15)
        { 
            <STDIN>;
        }
        else
        {
            print "\n";
        }
    }
    # Print a divider for every 15 lines.
    if (@page >= 15)
    {
        print "-" x 40;
        <STDIN>;
        # Clears the screen after executing 15 lines of code. 
        print "\n" x $rows;
        $linecount = 0;
    }
    undef(@page);
} while (defined $line);

# Exits with success.
exit 0;
