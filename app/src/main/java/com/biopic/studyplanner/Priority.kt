package com.biopic.studyplanner

enum class Priority(
    val label : String,
    val priorityType: PriorityType
) {
    LOW_PRIORITY("Low", PriorityType.LOW),
    MEDIUM_PRIORITY("Medium", PriorityType.MEDIUM),
    HIGH_PRIORITY("High", PriorityType.HIGH)
}