import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ConfigService {

  private _api_url = 'http://localhost:8080/api';
  private _user_url = this._api_url + '/users';

  private _login_url = this._user_url + '/login';
  private _post_url = this._api_url + '/posts';
  private _group_url = this._api_url + '/groups';

  get login_url(): string {
    return this._login_url;
  }

  private _whoami_url = this._user_url + '/whoami';

  get whoami_url(): string {
    return this._whoami_url;
  }

  private _users_url = this._user_url + '/all';

  get users_url(): string {
    return this._users_url;
  }

  private _club_url = this._api_url + '/clubs';

  get club_url(): string {
    return this._club_url;
  }
  get post_url(): string{
    return this._post_url;
  }

  get group_url(): string{
    return this._group_url;
  }
  get signup_url(): string {
    return this._user_url;
  }

}
