package ma.nory.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public final class UsersData {

	public static final UserDetails getUsersData() {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		Authentication authentication = securityContext.getAuthentication();
		Object principal = null;
		
		if (authentication != null) {
			principal = authentication.getPrincipal() instanceof UserDetails ? authentication.getPrincipal() : null;
		}
		
		return (UserDetails) principal;
	}
	
}