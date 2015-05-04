#! /usr/bin/python2
"""
Author:        Kristy Carrion
Date:          March 27, 2013
Last Modified: March 31, 2013 
Program:       Parser

Note: Script must be run using python 2.7

The purpose of this program is to be an interpreter for arithmetic expressions
as defined by the following grammar:
    
     <bexpr>        -> <expr> ;
     <expr>         -> <term> <ttail>
     <ttail>        -> <add_sub_tok> <term> <ttail> | SIGMA
     <term>         -> <stmt> <stail>
     <stail>        -> <mult_div_tok> <stmt> <stail>  | SIGMA
     <stmt>         -> <logic> <ltail>
     <ltail>        -> <log_tok> <logic> | <expp>
     <logic>        -> <expp> ^ <logic> | <expp>
     <expp>         -> ( <expr> ) | <num>
     <add_sub_tok>  -> + | -
     <mul_div_tok>  -> * | /
     <log_tok>      -> < | > | <= | >= | != | ==
     <num>          -> {0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9} +

This grammar is implemented using a recursive descent parser. It will
determine whether each expression that is inputed by the user is syntacically
correct. If the expressions are syntactically correct than the script will
evaluate the expression and return the resulting value.

This parser assumes Left Associativity for all operators expect for 
exponentiation (which has right associativity).

"""

""" 
Added to support regular expressions string comparisons.
"""
import re

""" 
Added to support command line arguments and exit commands. 
"""
import sys

"""
Added to support command line editing when entering input.
"""
import readline


"""
Constant used to hold the value for true.
"""
TRUE     = 1

"""
Constant used to hold the value for false.
"""
FALSE    = 0

"""
Constant used to hold the value that marks the beginning of a list.
"""
FIRST    = 0

"""
Constant used to hold the value of the final amount of tokens that should be
returned when expression is finished evaluating.
"""
LEFTOVER = 1

"""
Constant to hold the value for the minimum number of arguments this program
expects, which is none.
"""
MIN_ARGS = 1


"""
The main function checks if any command line arguments have been given, if so
it will generate a warning that they will be ignored. Then the main function
prompts the user to enter an algorithmic expression. Then the program will then
call the class "Parser" in order to begin to create a parse tree with the given 
grammar. If the expression is not syntactically correct the program will tell 
the user that given grammar syntax is incorrect and then prompt the user for 
another sentence until the user enteries "q" in which case the program will exit.

Returns: None.
"""
def main():
    if(len(sys.argv) > MIN_ARGS):
        print("Warning: Arguments entered will be ignored.")
    
    print("parser")
    p1 = Parser()
    while (p1.get_string() != "q"):
        print ("Please enter expression:"), 
        p1.set_string(raw_input())
        if (p1.get_string() != "q"):
            p1.tokenize()
            value  = p1.bexpr()
            if(value == "ERROR"):
                print("Syntax Error")
            else:
                print("Syntax OK\nValue is " + str(value))

    print("Goodbye!")
    sys.exit(0)
    
"""
This is a class representing a parser that contains methods for our grammar, 
specified at the top. It parses a simple math algorithmic expression then
determines whether it is in the grammar or not.
"""
class Parser:
    
    """
    Constructor for our class, that will declare fields for use in the class.
    """
    def __init__(self):

        """
        String field that holds the remaining pieces of the expression that was
        entered in by the user. 
        """
        self.string = ""

        """
        String field that is used to hold the current token inside of the 
        parser.
        """
        self.token = ""


    """
    Function for tokenizing the given input of simple math and logical 
    expressions. The function will create tokens from the input by breaking the 
    simple math and the logical expressions down into individual pieces. This
    function will determine a token, one at a time, via function calls in the 
    parser. 

    Returns: The next token available in the expression.
    Param:   Reference to the object that this function belongs to.
    """
    def tokenize(self):
        split_line    = re.compile('[\d]+|[\(\);\^*+/\-]|[!><][=]?|==|[^\s]+?')
        self.token    = re.search(split_line, self.string)
        if(self.token == None):
            self.token = "ERROR"
            return
        self.token    = self.token.group(0)
        self.string   = re.sub(split_line, '', self.string, 1)

    def set_string(self, new_string):
        self.string = new_string
    
    def get_string(self):
        return self.string

    """
    Helper function that is used to get the current token.

    Returns: The current token.
    Param:   Reference to the object that this function belongs to.
    """
    def get_token(self):
        return self.token


    """
    This function models a part of the grammar:
        <bexpr>  -> <expr> ;

    The bexpr function will call the expr function, and after the value is 
    returned it will determine whether or not the user entered in a ";". If the 
    user has not entered in the expected  ";" then this function will return a 
    Syntax Error.If the expr function returns a value of error then the function
    will just return that ERROR. Or if the length on tokens returned is less 
    then 1 it will also return an ERROR if there is more than one token left, 
    in which the user may have entered extra characters after the ";".

    Returns: The final evaluated token value, or ERROR if after the ";" has 
             already been evaluated that are are more larger than 1, or it will 
             ERROR if that last token is not a ";".
    Param:   Reference to the object that this function belongs to.
    """
    def bexpr(self):
        subtotal = self.expr()
        if(subtotal == "ERROR"):
            return "ERROR"
        if self.get_token() != ";":
            print("===> \';\' expected")
            return "ERROR"
        self.tokenize()
        if self.token != "ERROR":
            return "ERROR"
        return subtotal


    """
    This function models a part of the grammar:
        <expr>  -> <term> <ttail>

    The expr function will call the term and ttail function but if term returns
    an ERROR the function will just return ERROR, instead of going ahead and 
    calling ttail.

    Returns: An evaluated value or ERROR if any of the functions called return an
             ERROR.
    Param:   Reference to the object that this function belongs to. 
    """
    def expr(self):
        subtotal = self.term()
        if (subtotal == "ERROR"):
            return subtotal
        else:
            return self.ttail(subtotal)

    """
    This function models a part of the grammar:
        <expp>  -> ( <expr> )  | <num>

    The expp function will determine if the current token is an opening parenthesis
    or a closing parenthesis. If the token is an opening parenthesis the function will
    call the expr function to evulate the expr inside of the parenthesis. Then
    if there is no closing parenthesis the program will print a Syntax Error and
    return ERROR. If the current token is not part of a parenthesis it will call
    the num function. This function also determines whether the current token
    is a digit, if it's not it will return ERROR.

    Returns: An evaluated value or ERROR if any of the functions called return an
             ERROR.
    Param:   Reference to the object that this function belongs to.
    """
    def expp(self):
        if (self.get_token() == "("):
            self.tokenize()
            subtotal = self.expr()
            if subtotal == "ERROR":
                return "ERROR"
            elif self.get_token() != ")":
                print ("===> ')' expected")
                return "ERROR"
            else:
                self.tokenize()
                return subtotal
        elif (not str.isdigit(str(self.get_token()))):
            return "ERROR"
        else:
            return self.num()

    """
    This function models a part of the grammar:
        <term>  -> <stmt> <stail>

    The term function will call both the stmt and stail function. It returns 
    ERROR if the logic stmt function returns ERROR, otherwise it will call the 
    stail function returning whatever value it evaluates to.

    Returns: An evaluated value or ERROR if any of the functions called return an
             ERROR.
    Param:   Reference to the object that this function belongs to.
    """
    def term(self):
       subtotal = self.stmt()
       if (subtotal == "ERROR"):
           return subtotal
       else:
           return self.stail(subtotal)

    """
    This function models a part of the grammar:
        <stmt>  -> <logic>  <ltail>

    The stmt function will call both logic and ltail function. It returns ERROR
    if the logic function returns ERROR, otherwise it will call ltail function 
    returning whatever value it evaluates to.

    Returns: An evaluated value or ERROR if any of the functions called return an
             ERROR.
    Param:   Reference to the object that this function belongs to.
    """
    def stmt(self):
        subtotal = self.logic()
        if(subtotal == "ERROR"):
            return subtotal
        else:
            return self.ltail(subtotal)

    """
    This function models a part of the grammar:
        <logic>  -> <expp> ^ <logic>  |  <expp>

    The logic function will etheir preform an exponent evaluation or it will call
    the function expp. If the token is an exponent expression then the function 
    will correctly determine it's value based on it's power and the base 
    expression. Then the function will return that evaluated subtotal. If the 
    function current token is an error it will return that ERROR, or if when 
    trying to call logic it receives error it will return that ERROR. If the 
    current token is not an exponent then it will just call the expp function 
    instead.

    Returns: An evaluated value or ERROR if any of the functions called return an
             ERROR.
    Param:   Reference to the object that this function belongs to.
    """
    def logic(self):
        subtotal = self.expp()
        if (subtotal == "ERROR"):
            return subtotal
        else: 
            if (self.get_token() == "^"):
                self.tokenize()
                logic_term = self.logic()
                if logic_term == "ERROR":
                    return "ERROR"
                return subtotal ** logic_term
            else:
                return subtotal

    """
    This function models a part of the grammar:
        <stail>  -> <mul_div_tok> <stmt> <stail>  |  SIGMA

    The stail function will determine whether the current token is a "*" or a 
    "/" operator and evaluate the expression. Then it will call term, followed 
    by a call to itself or it will just evaluate everything to SGIMA.
    The function will return "ERROR" calling any function would result in ERROR 
    or it will return the evaluated expression.

    Returns: An evaluated number based on if the expression contained a "*" or "/"
             operator, otherwise it will return the number. If there is an ERROR
             that was passed to this function from another function it will 
             return that error.
    Param:   Reference to the object that this function belongs to.
    Param:   A number.
    """
    def stail(self, num):
        if (self.get_token() == "*"):
            self.mul_div_tok()
            st_value = self.stmt()
            if (st_value == "ERROR"):
                return stm_value
            else:
                return self.stail(num * st_value)
        elif (self.get_token() == "/"):
            self.mul_div_tok()
            st_value = self.stmt()

            if(st_value == "ERROR"):
                return st_value
            else:
                return self.stail(num / st_value)
        else:
            return num

    """
    This function models a part of the grammar:
        <ttail>  -> <add_sub_tok> <term> <ttail>  |  SIGMA

    The ttail function will determine whether the current token is a "+" or a 
    "-" operator and evaluate the expression. Then it will call term, followed 
    by a call to itself or it will just evaluate everything to SIGMA.
    The function will return "ERROR" calling any function would result in ERROR 
    or it will return the evaluated expression. 

    Returns: An evaluated number based on if the expression contained a "+" or 
             "-" operator, otherwise it will return the number. If there is an 
             ERROR that was passed to this function from another function it 
             will return that error.
    Param:   Reference to the object that this function belongs to.
    Param:   A number.
    """
    def ttail(self, num):
        if(self.get_token() == "+"):
            self.add_sub_tok()
            term_value = self.term()
            if(term_value == "ERROR"):
                return term_value
            else:
                return self.ttail(num + term_value)
        elif (self.get_token() == "-"):
            self.add_sub_tok()
            term_value = self.term()
            if(term_value == "ERROR"):
                return term_value
            else:
                return self.ttail(num - term_value)
        else:
            return num

    """
    This function models a part of the grammar:
        <ltail>  -> <log_tok> <logic> <ltail> | SIGMA

    The ltail function can ether evaluate any log_tok expression and then call
    the logic function, then call itself, but it can also evaluate to SIGMA, 
    in which it will return the number it was handed back up. If the current 
    token is a log_tok expression then it will evaluate it and return the 
    evaluated expression.

    Returns: 0 or 1 if the expression is true or false, or ERROR if there is an
             error that was passed to this function from another function. 
    Param:   Reference to the object that this function belongs to.
    Param:   A number.
    """
    def ltail(self, num):
        subtotal = "ERROR"
        curr_tok = self.get_token()
        if curr_tok == "<":
            self.log_tok()
            subtotal = self.logic()
            if (subtotal == "ERROR"):
                return num
            subtotal = TRUE if num < subtotal else FALSE

        elif curr_tok == ">":
            self.log_tok()
            subtotal = self.logic()
            if (subtotal == "ERROR"):
                return num
            subtotal = TRUE if num > subtotal else FALSE

        elif curr_tok == "<=":
            self.log_tok()
            subtotal = self.logic()
            if (subtotal == "ERROR"):
                return num
            subtotal = TRUE if num <= subtotal else FALSE

        elif curr_tok == ">=":
            self.log_tok()
            subtotal = self.logic()
            if (subtotal == "ERROR"):
                return num
            subtotal = TRUE if num >= subtotal else FALSE

        elif curr_tok == "==":
            self.log_tok()
            subtotal = self.logic()
            if (subtotal == "ERROR"):
                return num
            subtotal = TRUE if num == subtotal else FALSE

        elif curr_tok == "!=":
            self.log_tok()
            subtotal = self.logic()
            if (subtotal == "ERROR"):
                return num
            subtotal = TRUE if num != subtotal else FALSE

        else:
            return num

        ltail_term = self.ltail(subtotal)
        if ltail_term == "ERROR":
            return subtotal
        return ltail_term

    """
    This function models a part of the grammar:
        <log_tok>  -> < | > | <= | != | ==

    The log_tok function removes the current token, then updates that token and
    returns it.

    Returns: Returns the next token.
    Param:   Reference to the object that this function belongs to.
    """
    def log_tok(self):
        return_token = self.get_token()
        self.tokenize()
        return return_token

    """
    This function models a part of the grammar:
        <num>  -> {0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9} +

    The num function removes the current token and then updates that token. We
    typecast it as an int for use of evaluating calculations, and return it.

    Returns: Returns the next token.
    Param:   Reference to the object that this function belongs to.
    """
    def num(self):
        return_token = self.get_token()
        self.tokenize()
        return int(return_token)

    """
    This function models a part of the grammar:
        <add_sub_tok>  -> + | -

    The add_sub_tok function removes from the list of tokens a "+" or "-" 
    operator, then updates that token, and returns it.

    Returns: Returns the next token.
    Param:   Reference to the object that this function belongs to.
    """
    def add_sub_tok(self):
        return_token = self.get_token()
        self.tokenize()
        return return_token

    """
    This function models a part of the grammar:
        <mul_div_tok>  -> * | /

    The mul_div_tok function removes from the list of tokens a "*" or "/" 
    operator, then updates the token and returns it.

    Returns: Returns the next token.
    Param:   Reference to the object that this function belongs to.
    """
    def mul_div_tok(self):
        return_token = self.get_token()
        self.tokenize()
        return return_token

"""
This will call the main function in order to ensure that it runs every time
this program is executed.
"""
main()
