package com.example.noSqlProject.enumeration;

public enum TypePrise {

    TYPE_1,           // Courant Alternatif (AC) - Standard Japon/USA
    TYPE_2,           // Courant Alternatif (AC) - Standard Européen (Mennekes)
    TYPE_3,           // Ancien standard français (rare aujourd'hui)

    // Charge Rapide (DC)
    CHA_DE_MO,        // Standard Japonais pour charge rapide
    CCS_COMBO_2,      // Standard Européen pour charge rapide
    TESLA_SUPERCHARGER, // Spécifique Tesla (NACS aux USA)

    // Prises domestiques
    DOMESTIC_E_F,     // Prise standard maison (Schuko / Type E)
    GREEN_UP,         // Prise domestique renforcée (Legrand)
    P17_INDUSTRIAL
}
