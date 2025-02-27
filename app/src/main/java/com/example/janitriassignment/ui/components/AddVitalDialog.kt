package com.example.janitriassignment.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AddVitalDialog(onDismiss: () -> Unit, onSubmit: (Int, Int, Int, Float, Int) -> Unit) {
    var systolicText by remember { mutableStateOf("") }
    var diastolicText by remember { mutableStateOf("") }
    var heartRateText by remember { mutableStateOf("") }
    var weightText by remember { mutableStateOf("") }
    var babyKicksText by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(
                text = "Add Vitals",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF9400D3)
            )
        },
        text = {
            Column {

                Row(modifier = Modifier.fillMaxWidth()) {
                    OutlinedTextField(
                        value = systolicText,
                        onValueChange = { systolicText = it },
                        label = { Text("Sys BP") },
                        modifier = Modifier.weight(1f),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    OutlinedTextField(
                        value = diastolicText,
                        onValueChange = { diastolicText = it },
                        label = { Text("Dia BP") },
                        modifier = Modifier.weight(1f),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = heartRateText,
                    onValueChange = { heartRateText = it },
                    label = { Text("Heart Rate") },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
                )
                OutlinedTextField(
                    value = weightText,
                    onValueChange = { weightText = it },
                    label = { Text("Weight (kg)") },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
                )
                OutlinedTextField(
                    value = babyKicksText,
                    onValueChange = { babyKicksText = it },
                    label = { Text("Baby Kicks Count") },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
                )
            }
        },
        confirmButton = {
            Button(onClick = {
                val systolic = systolicText.toIntOrNull() ?: 0
                val diastolic = diastolicText.toIntOrNull() ?: 0
                val heartRate = heartRateText.toIntOrNull() ?: 0
                val weight = weightText.toFloatOrNull() ?: 0f
                val babyKicks = babyKicksText.toIntOrNull() ?: 0
                onSubmit(systolic, diastolic, heartRate, weight, babyKicks)
            }) {
                Text("Submit")
            }
        },
        dismissButton = {
            Button(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    )
}
