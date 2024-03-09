package com.febatis.googlekeepdosguri.domain.listnote.model

import android.icu.text.CaseMap.Title

class NoteListModel(
    val success: Boolean,
    val payload: List<NoteModel>
)