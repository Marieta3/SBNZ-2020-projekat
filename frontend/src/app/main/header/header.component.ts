import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/authentication/services/auth.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  constructor(
    private authService: AuthService,
  ) { }

  ngOnInit(): void {
  }

  get isUserLoggedIn() {
    return !!this.authService.isLogedIn();
  }

  get isAdmin() {
    return this.authService.isAdmin();
  }

  get isUser() {
    return this.authService.isUser();
  }

  logout() {
    this.authService.logOut();
  }

}
