#lang racket
; Author: Kristy Carrion
; Date: 04/10/2013
;
; The purpose of the following is to add polynomials together.

; This defines the terms of the contract, in which this script expects
; two polynomials to be passed to it, in order to be added together.
(provide (contract-out
[add-poly (poly? poly? . -> . poly?)]
))

(require "poly.rkt")

; This section of code will
(define same-variable?
  (lambda (poly1 poly2)
    (eqv? (get-variable poly1) (get-variable poly2))))

(define add-poly
  (lambda (poly1 poly2)
    (if (not same-variable? poly1 poly2) null
        (make-poly (get-variable poly1)(make-terms 
          (add-poly-help (get-terms poly1) (get-terms poly2)))))))

(define add-poly-help
  (lambda (poly1 poly2)
    (cond (zero-poly? poly1) 
          (append (get-first-term poly2) 
                  (add-poly-help(poly1 poly2))))
    (cond (zero-poly? poly2)
          (append (get-first-term poly1)
                  (add-poly-help(poly1 poly2))))
    (+ (get-coffiecent(poly1)) (get-coffiecent(poly2)))
    (ma
    ))
  
