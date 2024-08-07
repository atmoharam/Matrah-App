import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LocalStorageService {

  private storage: Storage | null;

  constructor() {
    // Check if window is defined
    if (typeof window !== 'undefined') {
      this.storage = window.localStorage;
    } else {
      this.storage = null;
    }
  }

  setItem(key: string, value: any): void {
    if (this.storage) {
      this.storage.setItem(key, JSON.stringify(value));
    } else {
      console.warn('LocalStorage is not available');
    }
  }

  getItem(key: string): any {
    if (this.storage) {
      const item = this.storage.getItem(key);
      return item ? JSON.parse(item) : null;
    } else {
      console.warn('LocalStorage is not available');
      return null;
    }
  }

  removeItem(key: string): void {
    if (this.storage) {
      this.storage.removeItem(key);
    } else {
      console.warn('LocalStorage is not available');
    }
  }

  clear(): void {
    if (this.storage) {
      this.storage.clear();
    } else {
      console.warn('LocalStorage is not available');
    }
  }
}
