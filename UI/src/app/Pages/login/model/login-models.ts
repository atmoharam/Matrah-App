export interface LoginRequest{
  username: string |null;
  password: string | null;
}

export interface LoginResponse{
  username: string,
  role: string,
  id: number,
  token: string
}
