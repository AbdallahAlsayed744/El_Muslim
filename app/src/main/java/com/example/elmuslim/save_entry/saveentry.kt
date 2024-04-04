package com.example.newsapp.save_entry

class saveentry(

    private val localmanger: localmanger
) {
    suspend operator fun invoke() {
        localmanger.saveentry()
    }


}