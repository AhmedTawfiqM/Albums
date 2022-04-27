package com.app.data.tmp

data class GlossEntry(val GlossTerm: String = "",
                      val glossSee: String = "",
                      val SortAs: String = "",
                      val glossDef: GlossDef,
                      val ID: String = "",
                      val acronym: String = "",
                      val abbrev: String = "")