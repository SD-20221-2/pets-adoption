import { messageActionTypes } from "../constants/messages";

const messageActions = {
  hide: () => ({
    type: messageActionTypes.HIDE
  })
}

export { messageActions }