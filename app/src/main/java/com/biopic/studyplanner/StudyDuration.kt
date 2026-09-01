package com.biopic.studyplanner

enum class StudyDuration(
    val label : String,
    val plannerType : PlannerType
) {
    ONE_HOUR("1h", PlannerType.GOAL),
    TWO_HOUR("2h", PlannerType.GOAL),

    FIFTEEN_MINUTE("15 min", PlannerType.SESSION),
    THIRTY_MINUTE("30 min", PlannerType.SESSION),
    FORTY_FIVE_MINUTE("45 min", PlannerType.SESSION),
    ONE_HOUR_THIRTY_MINUTE("1h 30m", PlannerType.SESSION)
}