package com.example.lab5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import androidx.navigation.compose.rememberNavController
import com.example.lab5.ui.theme.Lab5Theme

class Profile : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab5Theme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "profile_screen") {
                    composable("profile_screen") { ProfileScreen(navController) }
                    composable("emergency_contact_screen") { EmergencyContact(navController) }
                }
            }
        }
    }
}

@Composable
fun ProfileScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopBar()
        Spacer(modifier = Modifier.height(16.dp))
        ProfilePicture()
        Spacer(modifier = Modifier.height(8.dp))
        UserName()
        Spacer(modifier = Modifier.height(16.dp))
        MenuOptions(navController)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(
        title = { Text("My Profile") },
        actions = {
            IconButton(onClick = { /* Acción para los ajustes */ }) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "Settings"
                )
            }
        }
    )
}

@Composable
fun ProfilePicture() {
    Icon(
        imageVector = Icons.Default.AccountCircle,
        contentDescription = "Profile Picture",
        modifier = Modifier
            .size(100.dp)
            .clip(CircleShape)
    )
}

@Composable
fun UserName() {
    Text(
        text = "Jack",
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(horizontal = 16.dp)
    )
}

@Composable
fun MenuOptions(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MenuButton("My Campus", "📍", onClick = {})
        MenuButton("My Friends", "👥", onClick = {})
        MenuButton("My Calendar", "📅", onClick = {})
        MenuButton("My Courses", "📘", onClick = {})
        MenuButton("My Grades", "🎓", onClick = {})
        MenuButton("My Groups", "👨‍👩‍👧‍👦", onClick = {})
        MenuButton("Emergency Contact", "🚑", onClick = { navController.navigate("emergency_contact_screen") })
    }
}

@Composable
fun MenuButton(label: String, symbol: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = symbol, fontSize = 24.sp)
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = label, fontSize = 16.sp)
        }
    }
}
