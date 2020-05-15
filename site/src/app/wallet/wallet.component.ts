import {Component, OnInit} from '@angular/core';
import {Wallet} from '../models/wallet.model';
import {ApiUri} from '../api.uri';
import {WalletHttpService} from './wallet.http.service';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-wallet-creator',
  templateUrl: './wallet.component.html',
  styleUrls: ['./wallet.component.css']
})
export class WalletComponent implements OnInit {
  wallets: Array<Wallet>;


  constructor(private http: HttpClient, private walletHttpService: WalletHttpService) {
    this.wallets = new Array<Wallet>();
    this.getWallets();
  }

  private getWallets(): void {
    this.http.get(ApiUri.userWallets).subscribe(success => {
      console.log(success);
      return success;
    }, error => console.log(error));
    console.log(this.wallets.length);
  }

  ngOnInit(): void {
  }

}